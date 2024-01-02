package in.thiru.service;



import java.util.List;

import in.thiru.entity.Mobile;

public interface IMobileService {
	
	List<Mobile> getAllMobiles();
	
	public boolean saveMobiles(Mobile mobile );
	
	
	public void deleteMobile(Integer mobileId);
	
	
	public Mobile getMobile(Integer mobileId);

}
