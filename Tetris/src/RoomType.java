public enum RoomType {
	SINGLE(1),
	DOUBLE(2),
	TWIN(2),
	TRIPLE(3),
	FAMILY(5),
	SUITE(2);

	private final int capacity;

	RoomType(int capacity){
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}
}
