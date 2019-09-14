package redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisTest {
	
	/**
	 * Java�� ����redis
	 * @param args
	 */
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.234.128", 6379);
		jedis.auth("root");
		System.out.println(jedis.ping());
	}
	
	@Test
	public void test1() {
		Jedis jedis = new Jedis("192.168.234.128", 6379);
		jedis.auth("root");
		jedis.set("strName", "�ַ�������");
		String result = jedis.get("strName");
		System.out.println(result);
		jedis.close();
	}
	
	@Test
	public void test2() {
		Jedis jedis = new Jedis("192.168.234.128", 6379);
		jedis.auth("root");
		
		String key = "applicationName";
		if(jedis.exists(key)) {
			System.out.println("��redis���ݿ��в�ѯ��������:"+jedis.get(key));
		}else {
			String result = "΢��";
			System.out.println("��mysql�в�ѯ��������:"+result);
			jedis.set(key, result);
		}
		jedis.close();
	}
}
