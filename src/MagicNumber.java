import java.lang.reflect.Field;

public class MagicNumber {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class<?> clazz = Integer.class.getDeclaredClasses()[0];
		Field cache = clazz.getDeclaredField("cache");
		cache.setAccessible(true);
		Integer[] array = (Integer[]) cache.get(clazz);
		array[130] = array[131];
		array[132] = array[119];
		int sum = Integer.valueOf(1+3);
		System.out.println(sum);

	}

}
