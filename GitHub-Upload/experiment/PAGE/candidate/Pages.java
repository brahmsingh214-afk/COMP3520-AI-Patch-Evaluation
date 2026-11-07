public final class Pages {
public static int count(int items, int pageSize) {
int fullPages = items / pageSize;
return fullPages + (items % pageSize == 0 ? 0 : 1);
}
}
