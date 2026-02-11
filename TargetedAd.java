/*
 * Problem 2.3.1 Sell My Pet Food
 */
public class TargetedAd {

  public static void main(String[] args)
  {
    DataCollector collector = new DataCollector();
    collector.setData("socialMediaPosts.txt", "targetWords.txt");

    String targetedUsernames = "";
    
    String currentPost = collector.getNextPost();

    while (!currentPost.equals("NONE"))
    {
      int firstSpace = currentPost.indexOf(" ");
      String username = currentPost.substring(0, firstSpace);
      String postContent = currentPost.substring(firstSpace + 1).toLowerCase();
      
      boolean isTargeted = false;
      String specificPet = "pet"; 
      
      String targetWord = collector.getNextTargetWord();
      while (!targetWord.equals("NONE"))
      {
        if (postContent.contains(targetWord.toLowerCase()))
        {
          isTargeted = true;
          
          if (targetWord.toLowerCase().contains("targetWords.txt") || targetWord.toLowerCase().contains("targetWords.txt")) {
              specificPet = "tiger";
          } else if (targetWord.toLowerCase().contains("gray") || targetWord.toLowerCase().contains("dog")) {
              specificPet = "wolf";
          }
        }
        targetWord = collector.getNextTargetWord();
      }

      if (isTargeted)
      {
        if (!targetedUsernames.contains(username))
        {
          targetedUsernames += username + " ";
          
          String advertisement = "Your furry friend will love our " + specificPet + " food!";
          collector.prepareAdvertisement("targetedAds.txt", username, advertisement);
        }
      }
      
      currentPost = collector.getNextPost();
    }
    
    System.out.println("Targeted advertisement 'targetedAds.txt' has been made.");
  }
}
