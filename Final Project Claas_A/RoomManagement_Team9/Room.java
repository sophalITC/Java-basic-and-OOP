public class Room {
    private String building;
    private Integer room;
    private String dayOfWeek;
    private String time;
    private String group;
    private String available;
    
    public Room(){

    }
    public Room(String building, String dayOfWeek, String time, Integer room){
        setBuilding(building);
        setRoom(room);
        setDayOfWeek(dayOfWeek);
        setTime(time);
    }
    public Room(String building, String dayOfWeek, String time, Integer room, String group, String avalaible) {
        setBuilding(building);
        setRoom(room);
        setDayOfWeek(dayOfWeek);
        setTime(time);   
        setGroup(group); 
        setAvailable(avalaible);
    }
    public void setBuilding(String building) {
        this.building = building;
    }
    public void setRoom(Integer room) {
        this.room = room;
    }
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public void setAvailable(String available) {
        this.available = available;
    }
    public String getBuilding() {
        return building;
    }
    public Integer getRoom() {
        return room;
    }
    public String getDayOfWeek() {
        return dayOfWeek;
    }
    public String getTime() {
        return time;
    }
    public String getGroup() {
        return group;
    }
    public String getAvailable() {
        return available;
    }

}
