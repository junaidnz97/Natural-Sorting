1)	Comparison is done by checking element by element of both the strings.Whole numbers that occur 
	consecutively are treated as a single element.Strings and special characters are treated as
	single elements.
	For eg:In "h12o$",the elements are "h","12","0","$.

2)	According to this code,preference is given to strings in the order of digit>letter>special character.
	

3)	When ever consecutive whole numbers occur all of them are taken together and treated as a single integer 	 and are then used for comparison.If both substring are numerically same the one with greater length is 	
	given preferrence.For eg:if 12 and 012 are the substring,their numerical values are same.But 012 should get a higher preference as it begins with 0.So for a substring with equal numerical value,the one with greater length is definitely preceeded by zero,and hence,gets a higher preference.If their string lengths are same,checking is done for the next element of each string.

4)	When ever letters occur strings are given preference in the lexicographic order.But when 2 of the 
	characters are same and thier cases are different,the smaller case character is given the preference.If both of their cases are also same,checking is done for the next element of the string.

5)	When special characters occur,preference is directly given according to their ascci values.

	



	
	----------The test cases shown in the code and their answers are explained as follows ----------
	
	

	Note:(">","<")denotes higher preference.

	i) 	 "0012" and "12"
		 Even though both have same numerical value,since first one begins with 0,
		 "0012" > "12"

	ii)	 "test2.txt" and "text10.txt"
		 Since "2" in string1 is numericallly less than "10" in string2
		 "test2.txt" > "text10.txt"

	iii) "1 2 10" and "1 10 2"
		 Since there is a space in between characters they are not treated as consecutive.Instead they are treated as 3 seperate elements.
	     Since "2" in string1 is numerically less than "10" in string2
		 "1 2 10" > "1 10 2"

	iv)	"1102" and "1210"
		Since "1102" is numerically less than "1210" 
		"1102" > "1210"

	v)  "1/5hello.txt" and "1/3hello.txt"
		Since "3" in string2 is numerically less than "5" in string 1
		"1/5hello.txt" < "1/3hello.txt"

	vi)  "93xyz.txt" and "pqrs.txt"
		 Comparison is done between "9" in string1 and "p" in string2
		 Since number is given more preference
		 "93xyz.txt" > "pqrs.txt"

	vii) "myfile.txt" and "$$xyz.txt"
		 Comparison is done between "m" and "$"
		 Since letter is given more preference,
		 "myfile.txt" > "$$xyz.txt"
	
	viii)"x123a12" and "x123bt"
		 Since "a" < "b",
		 "x123a12" > "x123bt"

	ix)	 "21.txt" and "2_1.txt"
		  Comparison will be done between "21" of string1 and "2" of string2
		  Since "21" is numerically greater than "2"
		  "21.txt"<"2_1.txt"

	x)	  "Abc" and "abc"
		  Comparison is done between "A" and "a".
		  Since smaller case gets higher preferencr,
		  "Abc" < "abc"

	xi)	  "xbc" and "Zpq"
		  Since "x" < "Z",lexicographically
		  "xbc" > "Zpq"

	xii)  "abc" and "abcd"
		  Since these strings are  same till the length of the minimum string,we assign greater preference
		  to the one with lesser length.
		  Hence,
		  "abc" > "abcd"