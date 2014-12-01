public interface Sorter {
    public <E extends Comparable<E>> E[] sort(E[] unsorted);
}
