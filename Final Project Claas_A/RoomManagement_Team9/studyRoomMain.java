import java.io.BufferedReader;
import java.io.InputStreamReader;

public class studyRoomMain {
    public static void roomMainPage() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sqlStudyRoom studyRoomData = new sqlStudyRoom();
        int choice;

        do{
        System.out.println("\n\t[1]. ADD STUDY ROOM");
        System.out.println("\t[2]. SEARCH AVAILABLE STUDY ROOM");
        System.out.println("\t[3]. UPDATE STUDY ROOM");
        System.out.println("\t[4]. VIEW STUDY ROOM");
        System.out.println("\t[5]. DELETE STUDY ROOM");
        System.out.println("\t[6]. EXIT");
        System.out.print("Your Choice: [ ]\b\b");
        choice = Integer.parseInt(br.readLine());
        switch(choice){
            case 1:
            System.out.println("\t\t>>>>WELCOME TO ADD STUDY ROOM DATA<<<<");
            System.out.print("NUMBER OF AVAILABLE STUDY ROOM TO ADD: ");
            int numAdd = Integer.parseInt(br.readLine());
            for (int i = 0; i < numAdd; i++){
                System.out.print("DAY: ");
                String day = br.readLine();
                System.out.print("TIME (24H): ");
                String time = br.readLine();
                System.out.print("ROOM: ");
                int room = Integer.parseInt(br.readLine());
                System.out.print("GROUP: ");
                String group = br.readLine();
                System.out.print("AVAILABLE: ");
                String available = br.readLine();
                System.out.print("BUILDING: ");
                String building = br.readLine();
                studyRoomData.Insert(day, time, room, group.trim().toUpperCase(), available.trim().toUpperCase(), building.trim().toUpperCase());
                
            }
            break;
            case 2:
            System.out.println("\t\t>>>>WELCOME TO SEARCH AVAILABLE STUDY ROOM<<<<");
            studyRoomData.SearchAvailable("YES");
            System.out.print("Enter ROOM to Search:\n");
            int search = Integer.parseInt(br.readLine());
            studyRoomData.SearchRoom(search);
            break;
            case 3:
            System.out.println("\t\t>>>>WELCOME TO UPDATE AVAILABLE LAB<<<<");
            System.out.println("ENTER THE FOLLOWING INFO TO UPDATE: ");
            System.out.print("ROOM: ");
            int room = Integer.parseInt(br.readLine());
            

            System.out.print("DAY: ");
            String day = br.readLine();
            System.out.print("TIME (24H): ");
            String time = br.readLine();
            
            System.out.println("ENTER THE NEW INFO TO UPDATE: ");
            System.out.print("DAY: ");
            String newDay = br.readLine();
            System.out.print("TIME (24H): ");
            String newTime = br.readLine();
            System.out.print("ROOM: ");
            int newRoom = Integer.parseInt(br.readLine());
            System.out.print("GROUP: ");
            String group = br.readLine();
            System.out.print("AVAILABLE: ");
            String available = br.readLine();
            System.out.print("BUILDING: ");
            String building = br.readLine();
            studyRoomData.Update(day, time, room, newTime, newDay, newRoom, group, available, building);
            break;
            case 4:
            System.out.println("\t\t>>>>WELCOME VIEW AVAILABLE STUDY ROOM<<<<");
            studyRoomData.View();
            break;
            case 5:
            System.out.println("\t\t>>>>WELCOME DELETE AVAILABLE STUDY ROOM<<<<");
            System.out.println("ENTER THE FOLLOWING INFO TO DELETE: ");
            System.out.print("ROOM: ");
            room = Integer.parseInt(br.readLine());
            

            System.out.print("DAY: ");
            day = br.readLine();
            System.out.print("TIME (24H): ");
            time = br.readLine();
            System.out.print("BUILDING: ");
            building = br.readLine();
            
            studyRoomData.Delete(room, time, day, building);
            break;
            case 6:
            studyRoomData.close();
            break;
        }
    }while (choice != 6);      
    }
}
