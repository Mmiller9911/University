package sis.studentinfo;

import junit.framework.*;

public class CharacterTest extends TestCase {
	public void testWhiteSpace(){
        String space1 = " ";
        String space2 = "\u0020";
        String newline = "\n";
        String tab = "\t";
        String lower = "b";
        String upper = "A";
        String enter = "\r";
        
		assertEquals(true, Character.isWhitespace(space1.charAt(0)));	
		assertEquals(true, Character.isWhitespace(space2.charAt(0)));
		assertEquals(true, Character.isWhitespace(tab.charAt(0)));
		assertEquals(true, Character.isWhitespace(newline.charAt(0)));
		assertEquals(true, Character.isWhitespace(enter.charAt(0)));
		assertEquals(false, Character.isWhitespace(upper.charAt(0)));
		assertEquals(false, Character.isWhitespace(lower.charAt(0)));
	}
		public void testIdentifiers(){
	        String lowerLetter = "a";
	        String upperLetter= "A";
	        String dollar = "$";
	        String pound = "£";
	        String number = "4";
	        String arrow= ">";
	        String bracket = ")";
	        
	        assertEquals(true, Character.isJavaIdentifierStart(lowerLetter.charAt(0)));
	        assertEquals(true, Character.isJavaIdentifierStart(upperLetter.charAt(0)));
	        assertEquals(true, Character.isJavaIdentifierStart(dollar.charAt(0)));
	        assertEquals(true, Character.isJavaIdentifierStart(pound.charAt(0)));
	        assertEquals(false, Character.isJavaIdentifierStart(number.charAt(0)));
	        assertEquals(false, Character.isJavaIdentifierStart(arrow.charAt(0)));
	        assertEquals(false, Character.isJavaIdentifierStart(bracket.charAt(0)));
		}
}