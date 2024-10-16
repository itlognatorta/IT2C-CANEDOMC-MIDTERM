
package it2c.canedomc.midterm;

import java.util.Scanner;

    public class IT2CCANEDOMCMIDTERM {
    
     public void addProject(){
         Scanner sc = new Scanner(System.in);
         config conf = new config();
         
         System.out.print("Enter project title: ");
         String pname = sc.next();
         System.out.print("Enter project description: ");
         String pdes = sc.next();
         System.out.print("Enter date submission (YYYY-MM-DD): ");
         String pdate = sc.next();
         System.out.print("Enter project Grade (0-100):  ");
         String pgrade = sc.next();
              
      String qrl = "INSERT INTO project (project_title, project_description, submission_date, grade) VALUES (?,?,?,?)";    
      conf.addRecord(qrl, pname, pdes, pdate, pgrade);
      
     }
     
      private void viewProject() {
        String votersQuery = "SELECT * FROM project";
        String[] votersHeaders = {"project_id", "name", "description", "submission date", "grade"};
        String[] votersColumns = {"project_id", "project_title", "project_description", "submission_date", "grade"};
        config conf = new config();
        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
      
     private void UpdateProject(){ 
        Scanner sc = new Scanner(System.in);
        
         System.out.print("Enter project ID: ");
         int id = sc.nextInt();
        
         System.out.print("Enter new project title: ");
         String upname = sc.next();
         System.out.print("Enter new project description: ");
         String updes = sc.next();
         System.out.println("Enter new date submission: ");
         String update = sc.next();
         System.out.println("Enter new project Grade: ");
         int ugrade = sc.nextInt();
              
        String sql = "UPDATE project SET pname = ?, pdes = ?, pdate = ?, grade = ?";
        
        config conf = new config();
        conf.updateRecord(sql, upname, updes, update, ugrade, id);
     }
     
          private void deleteProject() {      
         Scanner sc = new Scanner(System.in);        
         System.out.print("Enter Project ID: ");
         int id = sc.nextInt();

        String sqlDelete = "DELETE FROM project WHERE id = ?";
        
        config conf = new config();
        conf.deleteRecord(sqlDelete, id);
    }
         
         
    
    public static void main(String[] args) {       
        
       
        Scanner sc = new Scanner(System.in);
        String response;
        
        do{
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            
            System.out.print("Enter choice: ");
            int action = sc.nextInt();
            
            IT2CCANEDOMCMIDTERM proj = new IT2CCANEDOMCMIDTERM();
            
            switch(action){
                
                case 1:
                    proj.addProject();
                    break;
                    
                case 2:   
                    proj.viewProject();
                   break;
                    
                case 3:    
                    proj.viewProject();
                    proj.UpdateProject();;
                    
                    break;
                    
                case 4:    
                    
                    proj.deleteProject();
                    
                    break;
            }     
            
                    System.out.println("Do you want to continue? (yes/no): ");        
                    response = sc.next();
                    
            }while(response.equals("yes"));
            System.out.println("Thankyou for using!");
            
                    
         
             
        
        
        
    }
    
}