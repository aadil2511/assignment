package assignmentpackage;
import java.util.*;

public class InvoiceRepository 
{
	LinkedHashSet<Product> lh = new LinkedHashSet<Product>();
	Customer c;
	public int isAddProduct(Customer c,Product p) 
	{
		this.c = c;
		
		for(Object obj:lh)
		{
			Product pr = (Product)obj;
				if(pr.getId()==p.getId()) 
				{
					return -1;		
			    }	
		}

	boolean b=lh.add(p);
	
		if(b) 
		{
			return 1;
		}else 
		{
			return 0;
		}
	}
	public void generateInvoice()
	{
		float bill=0;
		for(Object obj:lh)
		{
			Product pr = (Product)obj;
			bill = bill + (float)pr.getPrice()*(float)pr.getQty();
		}
		
		System.out.println("bill without gst");
		System.out.println(bill);
		System.out.println("bill with gst");
		System.out.println(bill*1.18);
	}
	
	public Product findProduct(String prodName) 
	{   Product pr1=null;
		for(Object obj:lh)
	{
		Product pr = (Product)obj;
			if(pr.getName().equals(prodName)) 
			{
				pr1= pr;	
				return pr1;
		    }	
	}
		return null;
	}
	public Product deleteProduct(String name)
	{   Product pr1 = null;
	for(Object obj:lh)
	{
		Product pr = (Product)obj;
			if(pr.getName().equals(name)) 
			{   lh.remove(pr);
				pr1= pr;	
				return pr1;
		    }	
	}
		return pr1;
	}
}
