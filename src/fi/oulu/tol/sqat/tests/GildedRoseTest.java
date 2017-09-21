package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
	
	
	
	@Test
	public void testUpdateEndOfDay_Sulfuras() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(80, itemBrie.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_Elixier() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 5, 7));
		
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(6, itemBrie.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_Conjured() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 3, 6));
		
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(4, itemBrie.getQuality());
		
	}
	
	@Test (expected=AssertionError.class)
	public void testUpdateEndOfDay_ToHighQuality() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("AgedBrie", 3, 50));
		
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(51, itemBrie.getQuality());
		
	}
	
	@Test 
	public void testUpdateEndOfDay_newNormalItem() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("ItemExample", 10, 15));
		
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemExample = items.get(0);
		assertEquals(14, itemExample.getQuality());
		
	}
	@Test
	public void testUpdateEndOfDay_SellIn0() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("ItemExample0", 0, 15));
		
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemExample0 = items.get(0);
		assertEquals(13, itemExample0.getQuality());
		
	}
	
	@Test 
	public void testUpdateEndOfDay_QualityGetsNegativ() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("ItemExampleNegativ", 3, 0));
		
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemExampleNegativ = items.get(0);
		assertEquals(0, itemExampleNegativ.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_negativQuality2() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("ItemExample", 0, 1));
		
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemExample0 = items.get(0);
		assertEquals(0, itemExample0.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePasses10() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes, Aged Brie", 10, 10));
		
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemExample = items.get(0);
		assertEquals(12, itemExample.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePasses5() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes, Aged Brie", 5, 10));
		
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item agedBri = items.get(0);
		assertEquals(13, agedBri.getQuality());
		
	}
	
	
	
		
	
	
	@Test
	public void testUpdateEndOfDay() {
		fail("Test not implemented");
	}
}
