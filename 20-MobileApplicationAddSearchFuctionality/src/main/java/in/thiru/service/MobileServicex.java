package in.thiru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.thiru.entity.Mobile;
import in.thiru.repo.MobileRepository;

@Service
public class MobileServicex implements IMobileService {

	@Autowired
	private MobileRepository mobileRepo;

	@Override
	public List<Mobile> getAllMobiles() {

		return mobileRepo.findAll();
	}

	@Override

	public boolean saveMobiles(Mobile mobile) {

		Mobile save = mobileRepo.save(mobile);
		if (save.getMobileId() != null) {
			return true;
		}

		return false;
	}

	@Override
	public void deleteMobile(Integer mobileId) {
		mobileRepo.deleteById(mobileId);

	}

	@Override
	public Mobile getMobile(Integer mobileId) {

		Optional<Mobile> findById = mobileRepo.findById(mobileId);
		if (findById.isPresent()) {
			Mobile mobile = findById.get();
			
			return mobile;
		}

		return null;
	}

}
