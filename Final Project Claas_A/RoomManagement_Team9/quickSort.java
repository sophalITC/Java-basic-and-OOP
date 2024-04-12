import java.util.ArrayList;

public class quickSort {
    protected ArrayList <Room> sortRoom(ArrayList <Room> listRoom){
        if(listRoom.size() <= 1){
            return listRoom;
        }
        ArrayList<Room> sorted = new ArrayList<Room>();
        ArrayList<Room> lesser = new ArrayList<Room>();
        ArrayList<Room> greater = new ArrayList<Room>();
        Room pivot = listRoom.get(listRoom.size()-1);
        for (int i = 0; i < listRoom.size() - 1; i++){
            if(listRoom.get(i).getRoom() < pivot.getRoom()){
                lesser.add(listRoom.get(i));
            }else{
                greater.add(listRoom.get(i));
            }
        }
        lesser = sortRoom(lesser);
        greater = sortRoom(greater);

        lesser.add(pivot);
        lesser.addAll(greater);
        sorted = lesser;

        return sorted;
    }
    int binarySearch(ArrayList<Integer> arr, int x)
    {
        int left = 0, right = arr.size() - 1;
       
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
   
            // Check if x is present at mid
            if (arr.get(mid) == x)
                return mid;
   
            // If x greater, ignore left half
            if (arr.get(mid) < x)
                left = mid + 1;
   
            // If x is smaller, ignore right half
            else
                right = mid - 1;
        }
   
        // if we reach here, then element was
        // not present
        return -1;
    }

}
