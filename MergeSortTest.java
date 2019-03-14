package snapcheck_payment_sorting;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

	List<PaymentObject> lists;
	@Before
	public void setUp() throws Exception {
		 lists = new ArrayList<>();
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 int id = 0;
		 Random rand = new Random();
		 while (id < 10000){
			lists.add(new PaymentObject(id++, rand.nextInt(10000), timestamp.getTime()+rand.nextInt(1000)));
		 }   
		 // SortUtil.shuffle(lists);
	}

	@After
	public void tearDown() throws Exception {
		Assert.assertTrue(SortUtil.verify(lists));
	}

	@Test
	public void testMergeSort() {
		SortUtil.mergeSort(lists, 0, lists.size()-1);
	}

}
