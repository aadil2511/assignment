package assignmentpackage;
import java.util.*;

public class InvoiceApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		InvoiceRepository ir = new InvoiceRepository();
		System.out.println("enter customer name email contact and id\n");
		String cname = sc.next();
		String cemail=sc.next();
		String ccontact=sc.next();
		int cid = sc.nextInt();
		Customer c = new Customer();
		c.setId(cid);
		c.setName(cname);
		c.setEmail(cemail);
		c.setContact(ccontact);
		
		do {
			System.out.println("enter the choice\n");
			int choice = sc.nextInt();
			switch(choice) {
		      case 1:
		    	  
				      System.out.println("enter the product name id price quantity\n");
				      String pname = sc.next();
				      Product p = new Product();
				      int pid = sc.nextInt();
				      int pprice = sc.nextInt();
				      int qty = sc.nextInt();
				      p.setId(pid);
				      p.setName(pname);
				      p.setPricel(pprice);
				      p.setQty(qty);
		              int b = ir.isAddProduct(c,p);
		    	     if(b==-1) {
		    	    	 System.out.println("product already present----->");
		    	     }else if(b==1) {
		    	    	 System.out.println("product added successfully--->");
		    	     }else {
		    	    	 System.out.println("some problem is there-->");
		    	     }
		    	     break;
		      case 2:
		    	     ir.generateInvoice();
		    	     break;
		      case 3:System.out.println("enter the product name");
		             String pname1 = sc.next();
		             Product p1 = ir.findProduct(pname1);
		             if(p1!=null) {
		            	 System.out.println("product found with data");
		            	 System.out.println(p1.getId()+" "+p1.getName()+" "+p1.getPrice()+" "+p1.getQty());
		             }
		             else {
		            	 System.out.println("not found");
		             }            		
		             break;
		      case 4:System.out.println("enter the product name");
	                 pname1 = sc.next();
	                 Product p2 = ir.deleteProduct(pname1);
	                 if(p2!=null) {
	                	 System.out.println("product deleted successfully");
	                 }else {
	                	 System.out.println("product not found");
	                 }
		}
		}while(true);
		
	}

}
