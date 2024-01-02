package in.thiru.service;

import org.springframework.stereotype.Service;

@Service
public class BookService 
{
    public int getNullPointerMessage() 
    {
    	String s=null;
    		
    	return s.length();
    }
}
