
public class CodeTester
  {
  private String[] letters;

  public CodeTester() // funstructor
    {
    letters = new String[26];
    letters[0] = "a";
    letters[1] = "b";
    letters[2] = "c";
    letters[3] = "d";
    letters[4] = "e";
    letters[5] = "f";
    letters[6] = "g";
    letters[7] = "h";
    letters[8] = "i";
    letters[9] = "j";
    letters[10] = "k";
    letters[11] = "l";
    letters[12] = "m";
    letters[13] = "n";
    letters[14] = "o";
    letters[15] = "p";
    letters[16] = "q";
    letters[17] = "r";
    letters[18] = "s";
    letters[19] = "t";
    letters[20] = "u";
    letters[21] = "v";
    letters[22] = "w";
    letters[23] = "x";
    letters[24] = "y";
    letters[25] = "z";
    }

  public int det2calc(int[][] matrix) // finds determinant of 2x2 matrix
  {

  if (matrix.length != 2 || matrix[0].length != 2)
    return -1;
  
  return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
  }

  public int det3calc(int[][] matrix) // finds determinant of 3x3 matrix
  {
  int first = 1;
  for (int i = 0; i < 3; i++)
    {
    first *= matrix[i][i];
    }
  int second = 1;
  for (int i = 0; i < 3; i++)
    {
    second *= matrix[i][(i + 1) % 3];
    }
  int third = 1;
  for (int i = 0; i < 3; i++)
    {
    third *= matrix[i][(i+2) % 3];
    }
  int fourth = 1;
  for (int i = 0; i < 3; i++)
    {
    fourth *= matrix[2-i][i];
    }
  int fifth = 1;
  for (int i = 0; i < 3; i++)
    {
    fifth *= matrix[(2-i) % 3][(i+1) % 3];
    }
  int sixth = 1;
  for (int i = 0; i < 3; i++)
    {
    sixth *= matrix[2-i][(i+2) % 3];
    }
  return ((first + second + third - fourth - fifth - sixth + 26000000) % 26);
  }
  
  public int modularInverse(int a) // finds modular inverse of a number mod 26
    {
    if (a % 2 == 0 || a % 13 == 0)
      return -1;
    int found = 0;
    for (int i = 0; i < 26; i++)
      if (a * i % 26 == 1)
        found = i;
    return found;
    }
  
  public String atbash (String pt)
  {
  pt = pt.toLowerCase();
  if (pt.length() == 0)
    return "";
  
  if (pt.substring(0, 1).equals(" "))
    return " " + atbash(pt.substring(1));

  if (pt.substring(0, 1).equals(","))
    return "," + atbash(pt.substring(1));

  if (pt.substring(0, 1).equals("."))
    if (pt.length() == 1)
      return ".";
    else
      return "." + atbash(pt.substring(1));

  if (pt.substring(0, 1).equals("'"))
    return "'" + atbash(pt.substring(1));

  int a = getNumValue(pt.substring(0, 1));
  return letters[25-a] + atbash(pt.substring(1));
  }

  public String caesarEncode(String pt, int shift)
    {
    pt = pt.toLowerCase();
    if (pt.length() == 0)
      return "";
      
    if (pt.substring(0, 1).equals(" "))
      return " " + caesarEncode(pt.substring(1), shift);

    if (pt.substring(0, 1).equals(","))
      return "," + caesarEncode(pt.substring(1), shift);

    if (pt.substring(0, 1).equals("."))
      if (pt.length() == 1)
      return ".";
    else
      return "." + caesarEncode(pt.substring(1), shift);
  
    if (pt.substring(0, 1).equals("'"))
      return "'" + caesarEncode(pt.substring(1), shift);
    
    int a = getNumValue(pt.substring(0, 1));

    return letters[(a + shift) % 26] + caesarEncode(pt.substring(1), shift);
    }

  public String caesarDecode(String pt, int shift)
    {
    pt = pt.toLowerCase();
    if (pt.length() == 0)
      return "";
      
    if (pt.substring(0, 1).equals(" "))
      return " " + caesarDecode(pt.substring(1), shift);

    if (pt.substring(0, 1).equals(","))
      return "," + caesarDecode(pt.substring(1), shift);

    if (pt.substring(0, 1).equals("."))
      if (pt.length() == 1)
        return ".";
      else
        return "." + caesarDecode(pt.substring(1), shift);
  
    if (pt.substring(0, 1).equals("'"))
      return "'" + caesarDecode(pt.substring(1), shift);
    
    int a = getNumValue(pt.substring(0, 1));

    return letters[(a - shift + 2600) % 26] + caesarDecode(pt.substring(1), shift);
    }

  public String affineEncode(String pt, int a, int b)
    {
    if (a % 2 == 0 || a % 13 == 0)
      return "You can't encode with this a value!";
    pt = pt.toLowerCase();
    if (pt.length() == 0)
      return "";
      
    if (pt.substring(0, 1).equals(" "))
      return " " + affineEncode(pt.substring(1), a, b);

    if (pt.substring(0, 1).equals(","))
      return "," + affineEncode(pt.substring(1), a, b);

    if (pt.substring(0, 1).equals("."))
      if (pt.length() == 1)
        return ".";
      else
        return "." + affineEncode(pt.substring(1), a, b);
  
    if (pt.substring(0, 1).equals("'"))
      return "'" + affineEncode(pt.substring(1), a, b);
    
    int c = getNumValue(pt.substring(0, 1));

    return letters[(c * a + b) % 26] + affineEncode(pt.substring(1), a, b);
    }

  public String affineDecode(String ct, int a, int b)
    {
    int modinverse = 0;
    if (a % 2 == 0 || a % 13 == 0)
      return "You can't encode with this a value!";
    ct = ct.toLowerCase();
    modinverse = modularInverse(a);

    b = (modinverse * ((26-b) % 26) + 2600) % 26;
    
    return affineEncode(ct, modinverse, b);
    }

  public String vigenereEncode(String pt, String keyword, int letter)
    {
    pt = pt.toLowerCase();
    if (pt.length() == 0)
      return "";
      
    if (pt.substring(0, 1).equals(" "))
      return " " + vigenereEncode(pt.substring(1), keyword, letter);

    if (pt.substring(0, 1).equals(","))
      return "," + vigenereEncode(pt.substring(1), keyword, letter);

    if (pt.substring(0, 1).equals("."))
      if (pt.length() == 1)
        return ".";
      else
        return "." + vigenereEncode(pt.substring(1), keyword, letter);
  
    if (pt.substring(0, 1).equals("'"))
      return "'" + vigenereEncode(pt.substring(1), keyword, letter);

    int currentletterval = getNumValue(keyword.substring(0, 1));

    int ptcurrent = getNumValue(pt.substring(0, 1));

    letter++;
    return letters[(ptcurrent + currentletterval + 260000) % 26] + vigenereEncode(pt.substring(1), keyword, (letter) % keyword.length());
    
    }

  public String vigenereDecode(String ct, String keyword, int letter)
    {
    ct = ct.toLowerCase();
    if (ct.length() == 0)
      return "";
      
    if (ct.substring(0, 1).equals(" "))
      return " " + vigenereDecode(ct.substring(1), keyword, letter);

    if (ct.substring(0, 1).equals(","))
      return "," + vigenereDecode(ct.substring(1), keyword, letter);

    if (ct.substring(0, 1).equals("."))
      if (ct.length() == 1)
        return ".";
      else
        return "." + vigenereDecode(ct.substring(1), keyword, letter);
  
    if (ct.substring(0, 1).equals("'"))
      return "'" + vigenereDecode(ct.substring(1), keyword, letter);

    int currentletterval = getNumValue(keyword.substring(0, 1));

    
    int ctcurrent = getNumValue(ct.substring(0, 1));

    letter++;
      
    return letters[(ctcurrent - currentletterval + 260000) % 26] + vigenereDecode(ct.substring(1), keyword, (letter) % keyword.length());
    }

  public String hillEncode(String pt, String keyword)
    {
    if (keyword.length() != 4)
      return "Invalid keyword length, try again!";

    pt = pt.toLowerCase();
    if (pt.length() == 0)
      return "";

    if (pt.length() % 2 != 0)
      pt += "z";
    
    int[][] encodearray = generateArray(keyword);

      
    int firstone = getNumValue(pt.substring(0, 1));

    int secondone = getNumValue(pt.substring(1, 2));

      
    int firstletter = encodearray[0][0] * firstone + encodearray[0][1] * secondone;
    int secondletter = encodearray[1][0] * firstone + encodearray[1][1] * secondone;

    if (pt.length() != 2)
    return letters[firstletter % 26] + letters[secondletter % 26] +   hillEncode(pt.substring(2), keyword);
    else
    return letters[firstletter % 26] + letters[secondletter % 26];
    }

  public String hillDecode(String ct, String keyword)
    {
    if (keyword.length() != 4)
      return "Invalid keyword length, try again!";

    ct = ct.toLowerCase();
    if (ct.length() == 0)
      return "";

    if (ct.length() % 2 != 0)
      ct += "z";

    int[][] origarray = generateArray(keyword);

    int determinant = det2calc(origarray);
    if (determinant % 2 == 0 || determinant % 13 == 0)
      return "You can't decode this hill cipher, the determinant is not coprime with 26!";
    determinant = (determinant + 2600) % 26;
    int inverse = modularInverse(determinant);

    int filla = origarray[1][1];

    origarray[1][1] = origarray[0][0];
    origarray[0][0] = filla;
    origarray[0][1] = (2600-origarray[0][1]) % 26;
    origarray[1][0] = (2600-origarray[1][0]) % 26;

      
    origarray[0][0] = (origarray[0][0] * inverse) % 26;
    origarray[0][1] = (origarray[0][1] * inverse) % 26;
    origarray[1][0] = (origarray[1][0] * inverse) % 26;
    origarray[1][1] = (origarray[1][1] * inverse) % 26;

    String drowyek = "";
    for (int i = 0; i < 2; i++)
      for (int j = 0; j < 2; j++)
        for (int k = 0; k < 26; k++)
          if (k == origarray[i][j])
            drowyek += letters[k];

    return hillEncode(ct, drowyek);
    }
  
  public int[][] generateArray(String keyword) // generates array for hills
    {
    if (keyword.length() == 4)
    {
      int[][] encarray = new int[2][2];
        for (int h = 0; h < 4; h++)
          for (int j = 0; j < 26; j++)
            if (letters[j].equals(keyword.substring(h, h+1)))
              encarray[h/2][h % 2] = j;
            return encarray;
    }
    else if (keyword.length() == 9)
    {
      int[][] encarray2 = new int[3][3];
      for (int h = 0; h < 9; h++)
          for (int j = 0; j < 26; j++)
            if (letters[j].equals(keyword.substring(h, h+1)))
              encarray2[h/3][h % 3] = j;
            return encarray2;
    }
    else 
    {
      int[][] encarraynull = new int[3][3];
      return encarraynull;
    }
    
    
    }

  public int getNumValue(String str) // returns the number value of a letter
  {
    System.out.println(str);
    int a = -1;
    for (int i = 0; i < letters.length; i++)
    {
      String comp = letters[i];
    }
      
  
    return a;
    }
  
  public String portaSolve(String text, String keyword, int counter)
  {
    text = text.toLowerCase();
    if (text.length() == 0)
      return "";
      
    if (text.substring(0, 1).equals(" "))
      return " " + portaSolve(text.substring(1), keyword, counter);

    if (text.substring(0, 1).equals(","))
      return "," + portaSolve(text.substring(1), keyword, counter);

    if (text.substring(0, 1).equals("."))
      if (text.length() == 1)
        return ".";
      else
        return "." + portaSolve(text.substring(1), keyword, counter);
  
    if (text.substring(0, 1).equals("'"))
      return "'" + portaSolve(text.substring(1), keyword, counter);
    
    int a = getNumValue(text.substring(0, 1));
    int b = getNumValue(keyword.substring(counter, counter+1));
    int c = b/2;
    counter++;
    if (a < 13)
      {
      return letters[(a+c) % 13 + 13] + portaSolve(text.substring(1), keyword, counter % (keyword.length()));
      }
    else
      {
      return letters[(a-c) % 13] + portaSolve(text.substring(1), keyword, counter % (keyword.length()));
      }
  }
  
  public int[][] cofactormat(int[][] enc)
  {
  int leftcorner = enc[0][0];
  int topmiddle = enc[0][1];
  int middleleft = enc[1][0];
  enc[0][0] = enc[2][2];
  enc[2][2] = leftcorner;
  enc[0][1] = enc[1][2];
  enc[1][2] = topmiddle;
  enc[1][0] = enc[2][1];
  enc[2][1] = middleleft;
  for (int i = 0; i < 3; i++)
    {
    for (int j = 0; j < 3; j++)
      {
      if ((i + j) % 2 == 1)
        enc[i][j] *= -1;
        enc[i][j] += 260000;
        enc[i][j] %= 26;
      }
    }
  return enc;
  }
   
  public String hillthreebythreeencode(String pt, String keyword)
  {
    if (keyword.length() != 9)
      return "Invalid keyword length, try again!";

    pt = pt.toLowerCase();
    if (pt.length() == 0)
      return "";
      
    if (pt.substring(0, 1).equals(" "))
      return " " + hillthreebythreeencode(pt.substring(1), keyword);

    if (pt.length() % 3 == 1)
      pt += "zz";
    else if (pt.length() % 3 == 2)
      pt += "z";
    
    int[][] array = new int[3][3];
    for (int i = 0; i < 9; i++)
      {
        // System.out.println("Current value: \t" + array[i/3][i % 3]);
        array[i/3][i % 3] = getNumValue(keyword.substring(i, i+1));
        // System.out.println("After value: \t" + array[i/3][i % 3]);
      }

    String threesome = "";
    for (int i = 0; i < 3; i++)
    {
    int currentval = 0;
      for (int j = 0; j < 3; j++)
      {
      System.out.println("Array Value\t" + array[i][j]);
      System.out.println("Current Value \t" + getNumValue(pt.substring(j, j+1)));
      currentval += array[i][j] * getNumValue(pt.substring(j, j+1));
      }
      threesome += letters[(currentval + 2600000) % 26];
      System.out.println(threesome);
    }
    if (pt.length() != 3)
      return threesome + hillthreebythreeencode(pt.substring(3), keyword);
    else
      return threesome;
  }

  public String hillthreebythreedecode(String ct, String keyword)
  {
    if (keyword.length() != 9)
      return "Invalid keyword length, try again!";

    ct = ct.toLowerCase();
    if (ct.length() == 0)
      return "";

    
    if (ct.length() % 3 == 1)
      ct += "zz";
    else if (ct.length() % 3 == 2)
      ct += "z";

    String reversekey = "";
    int[][] enc = generateArray(keyword);
    int[][] encco = cofactormat(enc);
    int multi = modularInverse(det3calc(enc));
    for (int i = 0; i < 3; i++)
      {
      for (int j = 0; j < 3; j++)
        {
        encco[i][j] *= multi;
        encco[i][j] += 260;
        encco[i][j] %= 26;
        reversekey += letters[encco[i][j]];
        }
      }
    // find cofactor matrix and change as necessary
    return hillthreebythreeencode(ct, reversekey);
  
  }

  public String aristocrat(String ct, String letterorig, String lettersub, boolean[] changedarray, boolean change)
  {
    String result = "";
    if (change == false) // new decode
    {
      for (int i = 0; i < ct.length(); i++)
      {
      if (changedarray[i] == false &&ct.substring(i, i+1).equals(letterorig))
        {
          result += lettersub;
          changedarray[i] = true;
        }
      else
        {
          result += ct.substring(i, i+1);
        }
      }
    }
    else // letter was already changed and needs correction
    {
      for (int i = 0; i < ct.length(); i++)
      {
      if (changedarray[i] == true && ct.substring(i, i+1).equals(letterorig))
        {
          result += lettersub;
          changedarray[i] = false;
        }
      else
        {
          result += ct.substring(i, i+1);
        }
      }
    }
    return result;
  }

  // public String baconian(String ct, String charorig, String lettersub)
  // string
  // substitutions
  // blocks of 5
}
