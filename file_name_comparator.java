public class file_name_comparator {

	public static int l1,l2;

	public static int compare(char[] c1,char[] c2)
	{
		/*	
		 * i and j denotes the current
		 * current index of c1 and c2 respectively
		 */
				
		int i=0,j=0;
		for(i=0,j=0;i<l1 && j<l2;i++,j++)
		{
			/*
			 *	Checking if c1[i] and c2[j],both characters are letters  
			 */
			
			if(Character.isLetter(c1[i]) && Character.isLetter(c2[j]))
			{
				int ascii_string1,ascii_string2;
				
				/*
				 * flag1 and flag2 are for checking if the respective character
				 * is converted from small to capital.
				 * If flag1=0,the character is already in capital and no changes are done,
				 * If flag1=1,the character is converted from small letter to capital letter.
				 * Same is the case for flag2
				 */
				
				int flag1=0,flag2=0;			
				
				ascii_string1=(int)c1[i];ascii_string2=(int)c2[i];
				
				if(ascii_string1>=97 && ascii_string1<=122)
				{	
					flag1=1;
					ascii_string1=ascii_string1-32;				//Converting from small letter to capital
				}
				
				if(ascii_string2>=97 && ascii_string2<=122)
				{	
					flag2=1;
					ascii_string2=ascii_string2-32;				//Converting from small letter to capital
				}
				
				/*
				 * Checking if both character are same irrespective of their case
				 */
				
				if(ascii_string1 == ascii_string2)
				{
					/*
					 *if they have the same case then continue
					 */
					
					if(flag1 == flag2)
						continue;
					
					/*
					 * Give priority to lower case character
					 */
					
					if(flag1==1 && flag2==0)
						return 0;
					else
						return 1;
				}
				
				/*
				 * If both characters are different,
				 * directly give priority according to ascii value
				 */
				
				else if(ascii_string1>ascii_string2)
				{
					return 1;
				}
				
				else 
					return 0;
			}
			
			/*
			 * Checking if either one of c1[i] or c2[j] is a letter
			 * and the other,a number.
			 * Priority is given to a number than a letter.
			 */
			
			else if(Character.isDigit(c1[i]) && Character.isLetter(c2[i]))
			{
				return 0;
			}
			else if(Character.isLetter(c1[i]) && Character.isDigit(c2[i]))
			{
				return 1;
			}
			
			/*
			 * Checking if c1[i] and c2[j],both characters are numbers
			 */
			
			else if(Character.isDigit(c1[i]) && Character.isDigit(c2[j]))
			{
				
				/*
				 * If both of them are numbers we have to check which one 
				 * of the substring is consecutively large.For this we run a while
				 * loop till the characters are not numbers.
				 * Even though a nested loop exists,the complexity is still
				 * O(strlen(c1)+strlen(c2)) since the nested loop also gets incremented w.r.t 
				 * i and j.According to the code,each element of both  c1 and c2 
				 * gets executed twice at maximum. 
				 */
				
				/*
				 * pos1 and pos2 stores the starting position of the substring.
				 * count1 and count 2 stores the length of the substring.
				 * flag variable is set to 1 if  
				 */
				
				int pos1=i,pos2=j,count1=0,count2=0;
				
			
				/*
				 * To find the consecutive substring that are numbers, 
				 * we can either store each character by character to another 
				 * string and convert it later to an integer.But that would make the space
				 * complexity of the function O(n).Since a solution with O(1)
				 * space complexity is asked,I found out the ending position of
				 * those substring in each c1 and c2 and stored them to variables count1 and count2
				 * respectively and start positions to variables pos1 and pos2 respectively.
				 */
				
				/*
				 * The logic for finding the substring is similar to
				 * that of merging 2 arrays.
				*/
				
				while(Character.isDigit(c1[i])==true && Character.isDigit(c2[j])==true)
				{
					count1++;
					count2++;
					i++;j++;
					if(i<l1 && j<l2) 		
					{	
						continue;
					}
					else
						break;
				}
				
				if(i<l1)
				{
					while(Character.isDigit(c1[i])==true)
					{
						count1++;
						i++;
						if(i<l1)
							continue;
						else
							break;
					}
				}
				
				if(j<l2)
				{
					while(Character.isDigit(c2[j])==true)
					{
						count2++;
						j++;
						if(j<l2)
							continue;
						else
							break;
					}
				}
				
				/*
				 *Now,since I have the starting position and ending position of the 2
				 *substrings,I just iterated from end to start of the substring and 
				 * stored it into integer variables val1 and val2 respectively.
				 *Now,by comparing val1 and val2,it's easy to check which string should
				 *get more preference.
				 *If they are equal,we continue searching for rest elements.  
				 */
				
				
				int val1=0,val2=0;
				
				int pow=1,temp=pos1+count1-1;
				while(temp>=pos1)
				{
					val1+=pow*(Character.getNumericValue(c1[temp]));
					pow=pow*10;
					temp--;
				}
				
				pow=1;temp=pos2+count2-1;
				while(temp>=pos2)
				{
					val2+=pow*(Character.getNumericValue(c2[temp]));
					pow=pow*10;
					temp--;
				}
				
				
				/*
				 * It is guaranteed that the control flow will go into the first while loop.
				 * There we are incrementing both i and j.If the substrings are same,
				 * the for loop at the top will again increment i and j which results
				 * in skipping of that element.For this to not happen,
				 * we decrement i and j by one unit.
				 */
				
				i--;
				j--;
				
				/*
				 * Now we assign priorities based on val1 and val2 
				 */
				
				if(val1==val2)
				{	
					/*
					 * Now,here is a corner case.Consider,for eg, if the substring was
					 * 012 and 12,logically preference should be given to 012.
					 * But while both are converted to integer,value of both will become same.
					 * To tackle this problem,we will make use of the count1 and count2 variables
					 * that has the length of each substring.If integer value is same and length of
					 * substrings different,it basically mean that the one with higher length
					 * is preceded by zero.So,the one with higher string length is given more
					 * priority. 
					 */
					
					if(count1 == count2)
						continue;
					
					else if(count1 < count2)
						return 1;
					
					else if(count1 > count2)
						return 0;
				
				}
				
				else if(val1<val2)
				{	
					return 0;
				}
				
				else if(val1>val2)
				{
					return 1;
				}
			
			}
			
			/*
			 *Here we are checking if one of the characters is a letter 
			 *and the other is a special character. 
			 * !Character.isLetter(c2[j]) is enough to check if
			 * it's a special character because all the other
			 * combinations are already checked.
			 * More priority is given to the letter than the special character.
			 */
			
			else if(Character.isLetter(c1[i]) &&  !Character.isLetter(c2[j]))
			{
				return 0;
			}
			
			else if(!Character.isLetter(c1[i]) && Character.isLetter(c2[j]))
			{
				return 1;
			}
			
			/*
			 *Here we are checking if one of the characters is a digit 
			 *and the other is a special character. 
			 * !Character.isLetter(c2[j]) is enough to check if
			 * it's a special character because all the other
			 * combinations are already checked.
			 * More priority is given to the digit than the special character.
			 */
			
			else if(Character.isDigit(c1[i]) && !Character.isLetter(c2[j]))
			{
				return 0;
			}
			
			else if(!Character.isLetter(c1[i]) && Character.isDigit(c2[j]))
			{
				return 1;
			}
			
			/*
			 * If both the characters are special characters we assign
			 * priority on basis of their ascii value.
			 */
			
			else if(!Character.isLetter(c1[i]) && !Character.isLetter(c2[j]))
			{
				if(c1[i]==c2[j])
				{
					continue;
				}
				
				else if((int)c1[i] > (int)c2[j])
				{
					return 1;
				}
				
				else
				{
					return 0;
				}
			}
			
		}
		
		/*
		 * Even after executing through the entire loop,
		 * If the control flow is still in the function,then
		 * it means that either both have the same name,or one is
		 * a substring of the other.So,now we assign priority
		 * based on length of the string.
		 */
		
		if(l1<l2)
		{
			return 0;
		}
		else if(l2>l1)
		{
			return 1;
		}
		else
		{
			return -1;
		}
					
	}

	
	public static void main(String[] args)
	{
		
		/*
		 * Test cases are explained in the "Readme.txt" file
		 */
		String[] s1= {"0012","test2.txt","1 2 10","1102","1/5hello.txt","93xyz.txt","myfile.txt","x123a12","21.txt","Abc","xbc","abc"};
		String[] s2= {"12","test10.txt","1 10 2","1210","1/3hello.txt","pqrs.txt","$$xyz.txt","x123bt","2_1.txt","abc","Zpq","abcd"};
		int length=s1.length;
		for(int i=0;i<length;i++)
		{
			l1=s1[i].length();
			l2=s2[i].length();
			int x=compare(s1[i].toCharArray(),s2[i].toCharArray());
			if(x==0)
				System.out.println(s1[i]+" > "+s2[i]);
			else if(x==1)
			 	System.out.println(s2[i]+" > "+s1[i]);
			else
				System.out.println("Same filename");

		}
	}

}
