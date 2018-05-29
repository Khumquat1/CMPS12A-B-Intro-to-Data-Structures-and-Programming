//import java.lang.Math.abs;

public class Lab8{
      public static void main(String[] args){
//      DateProfile Kevin =  new DateProfile('M', 'F', 10, 1, "Kevin");
//      DateProfile Gay =  new DateProfile('M', 'M', 1, 10, "Gay");
//      DateProfile Nhu = new DateProfile('F', 'M', 10, 1, "Nhu");
//      DateProfile Test =  new DateProfile();
      DateProfile[] profile = new DateProfile[4];
      profile[0] = new DateProfile('M', 'F', 10, 1, "Kevin");
      profile[1] = new DateProfile('M', 'F', 3, 2, "Test");
      profile[2] = new DateProfile('F', 'M', 10, 1, "Nhu");
      profile[3] = new DateProfile();
      
      for(int k =0; k<4; k++){
         System.out.print(profile[k].name+": "+profile[k].gender+" ");
         System.out.print(profile[k].searchGender+" "+profile[k].romance+" "+profile[k].finance);
         System.out.println();
      }
      for(int i=0; i<4; i++){
         for(int j=0; j<4; j++){
            displayTwoProfiles(profile[i], profile[j]);
         }
         System.out.println();
      }
   }
   static void displayTwoProfiles(DateProfile profile1, DateProfile profile2 ){
      System.out.print("Fit between "+profile1.name+" and "+profile2.name+": ");
      System.out.println(profile1.fitValue(profile2));
   }
   private static class DateProfile{
      // instance members and constants
      private char gender;
      private char searchGender;
      private int romance;
      private int finance;
      private String name;
      
      int MIN_INT_RANGE = 1;
      int MAX_INT_RANGE = 10;
      int MIN_NAME_LEN = 2;
      int MAX_NAME_LEN = 32;

      char DEFAULT_GENDER = 'F';
      char DEFAULT_SEARCH_GENDER = 'M';
      int DEFAULT_ROMANCE = 7;
      int DEFAULT_FINANCE = 8;
      String DEFAULT_NAME = "Test";
      
      // Constructors 
      DateProfile(){
         gender = DEFAULT_GENDER;
         searchGender = DEFAULT_SEARCH_GENDER;
         romance = DEFAULT_ROMANCE;
         finance = DEFAULT_FINANCE;
         name = DEFAULT_NAME;
      }    
      DateProfile(char gender, char searchGender, int romance, int finance, String name){
         if(validGender(gender)) 
            this.gender = gender;
         else
            this.gender = DEFAULT_GENDER;
         if(validGender(searchGender))
            this.searchGender = searchGender;
         else
            this.searchGender = DEFAULT_SEARCH_GENDER;
         if(validIntRange(romance))
            this.romance = romance;
         else
            this.romance = DEFAULT_ROMANCE;
         if(validIntRange(finance))
            this.finance = finance;
         else
            this.finance = DEFAULT_FINANCE;
         if(validString(name))
            this.name = name;
         else
            this.name = DEFAULT_NAME;
      }
      
      // Access functions
      char getGender(){
         return gender;
      }
      char getSearchGender(){
         return searchGender;
      }
      int getRomance(){
         return romance;
      }
      int getFinance(){
         return finance;
      }
      String getName(){
         return name;
      }
      
      // Other functions
      double determineFinanceFit(DateProfile partner){
         double ans;
         ans =  1.0 - Math.abs(partner.getFinance()- this.getFinance())/10.;
//         System.out.println("in DFF, I got "+ans+" with "+partner.getFinance()+" "+this.getFinance());
         return ans;        
         
      }
      double determineRomanceFit(DateProfile partner){
         double ans;
         ans = 1.0 - Math.abs(partner.getRomance()- this.getRomance())/10.;
//         System.out.println("in DRF, I got "+ans+" with "+partner.getRomance()+" "+this.getRomance());
         return ans; 
      }
      double determineGenderFit(DateProfile partner){
         if(partner.getGender() == this.getSearchGender() && partner.getSearchGender() == this.getGender()){
 //           System.out.println("\nDGF MATCH with "+partner.getGender()+" "+this.getGender());
            return 1.0;
         }
         else{
//            System.out.println("\nDGF FAIL with "+partner.getGender()+" "+this.getGender());
            return 0.0;
         }
      }
      double fitValue(DateProfile partner){
         double ans;
         ans = Math.round(determineGenderFit(partner)*((determineRomanceFit(partner)+determineFinanceFit(partner))/2.0));
         return ans; 
      }
      boolean validGender(char gender){
         return gender== 'M' || gender== 'F' || gender== 'm' || gender== 'f';
      }
      boolean validIntRange(int value){
         return (value <= MAX_INT_RANGE && value >= MIN_INT_RANGE);
      }
      boolean validString(String s){
         if(s == null) 
            return false;
         else
            return (s.length() <= MAX_NAME_LEN && s.length() >= MIN_NAME_LEN);
      }
   }

}
   