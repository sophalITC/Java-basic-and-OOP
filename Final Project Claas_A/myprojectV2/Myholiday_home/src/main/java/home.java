public class home{
	int id;
	String type;
	String landsize;
	String room;
	String location;
	String dicrection;
	String special;
	String price;
	public home(int id, String type, String landsize, String room, String location, String dicrection, String special,String price) {
		this.id = id;
		this.type = type;
		this.landsize = landsize;
		this.room = room;
		this.location = location;
		this.dicrection = dicrection;
		this.special = special;
		this.price = price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setLandsize(String landsize) {
		this.landsize = landsize;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setDicrection(String dicrection) {
		this.dicrection = dicrection;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
}