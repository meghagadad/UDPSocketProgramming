package dummy;

import java.nio.ByteBuffer;

public class Options {
    
	//The current option's number
		private int optionNum;
		
   //The current option's data
		private ByteBuffer value;
	
	//constructors

		/*This is a constructor for a new option with a given number, based on a
		 * given byte array
		 * 
		 * @param value The byte array
		 * @param num The option number
		 * 
		 * @return A new option with a given number based on a byte array
		 */
		public Options (byte[] ran, int num) {
			setValue(ran);
			setOptionNum(num);
		}
		
		/*
		 * This is a constructor for a new option with a given number, based on a
		 * given string
		 * @param str The string
		 * @param nr The option number
		 * 
		 * @return A new option with a given number based on a string
		 */
		public Options (String str, int nr) {
			setStringValue(str);
			setOptionNum(nr);
		}
		
		/*
		 * This is a constructor for a new option with a given number, based on a
		 * given integer value
		 * 
		 * @param val The integer value
		 * @param nr The option number
		 * 
		 * @return A new option with a given number based on a integer value
		 */
		public Options (int val, int nr) {
			setIntValue(val);
			setOptionNum(nr);
		}
		
		/*
		 * This method sets the current option's data to a given byte array
		 * 
		 * @param value The byte array.
		 */
		public void setValue (byte[] value) {
			this.value = ByteBuffer.wrap(value);
		}
		
		/*
		 * This method sets the number of the current option
		 * 
		 * @param nr The option number.
		 */
		public void setOptionNum (int nr) {
			optionNum = nr;
		}
		
		/*
		 * This method sets the data of the current option based on a string input
		 * 
		 * @param str The string representation of the data which is stored in the
		 *            current option.
		 */
		private void setStringValue(String str) {
			value = ByteBuffer.wrap(str.getBytes());	
		}
		
		/*
		 * This method sets the data of the current option based on a integer value
		 * 
		 * @param val The integer representation of the data which is stored in the
		 *            current option.
		 */
		private void setIntValue(int val) {
			int neededBytes = 4;
			if (val == 0) {
				value = ByteBuffer.allocate(1);
				value.put((byte) 0);
			} else {ByteBuffer aux = ByteBuffer.allocate(4);//allocates new buffer
				aux.putInt(val);//writes int val
				for (int i=3; i >= 0; i--) {
					if (aux.get(3-i) == 0x00) {
						neededBytes--;
					} else {
						break;
					}
				}
				value = ByteBuffer.allocate(neededBytes);
				for (int i = neededBytes - 1; i >= 0; i--) {
					value.put(aux.get(3-i));
				}
			}
		}
		
		public int getOptionNumber() {
		return optionNum;
	}
	
	

	

	
	

}
