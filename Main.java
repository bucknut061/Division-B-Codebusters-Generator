class Main {
    public static void main(String[] args) 
    {
    KeyboardReader reader = new KeyboardReader();
    CodeTester willy = new CodeTester();
    String input = "";
    String keyword = "";
    String guess = "";
    boolean correct = false;
    int choicenumber = 69;
    while (choicenumber != 420)
      {
      System.out.println("Menu \n 1. Atbash encode \n 2. Atbash decode \n 3. Caesar encode \n 4. Caesar decode");
      System.out.println(" 5. Affine encode \n 6. Affine decode \n 7. Vigenere encode \n 8. Vigenere decode");
      System.out.println(" 9. 2x2 Hill encode \n 10. 2x2 Hill decode \n 11. Porta Encode \n 12. Porta Decode");
      System.out.println(" 13. Tester (does nothing) \n 14. 3x3 Hill encode (NOT FUNCTIONAL) \n 15. 3x3 Hill decode (NOT FUNCTIONAL) \n 16. Aristocrat Helper");
      System.out.println(" 17. Xenocrypt Helper \n 18. Patristocrat Helper \n 19. K1 Cipher Helper \n 20. K2 Cipher Helper \n 420. Exit");
      choicenumber = reader.readInt("Select your option. \t\t\t");
      input = "";
      keyword = "";
      guess = "";
      correct = false;
  
      
      if (choicenumber == 1) // atbash encode
        {
        input = reader.readLine("Enter the phrase you would like to encode, with words separated by spaces and ending with a period. \n");
        reader.pause();
        String returning = willy.atbash(input);
        String caps = returning.substring(0, 1).toUpperCase();
        returning = caps + returning.substring(1);
        
        
        while (!correct)
          {
          guess = reader.readLine("What is the new text? Enter your guess in the same format as the sentence you entered. Only the first letter is capitalized.\n");
          if (guess.equals(returning))
            {
            System.out.println("Congratulations! You correctly encrypted this atbash cipher.\n");
            correct = true;
            }
          else if (guess.equals("v") || guess.equals("V"))
            {
            System.out.println("SOLUTION: \t" + returning);
            correct = true;
            }
          else
            {
            System.out.println("Not quite. Guess again. Or enter v to view the solution.\n");
            }
          }
        }
  
      else if (choicenumber == 2) // atbash decode
        {
        input = reader.readLine("Enter the phrase you would like to decode, with words separated by spaces and ending with a period. \n");
        reader.pause();
        String returning = willy.atbash(input);
        String caps = returning.substring(0, 1).toUpperCase();
        returning = caps + returning.substring(1);
        
        while (!correct)
          {
          guess = reader.readLine("What is the new text? Enter your guess in the same format as the sentence you entered. Only the first letter is capitalized.\n");
          if (guess.equals(returning))
            {
            System.out.println("Congratulations! You correctly decrypted this atbash cipher.\n");
            correct = true;
            }
          else if (guess.equals("v") || guess.equals("V"))
            {
            System.out.println("SOLUTION: \t" + returning);
            correct = true;
            }
          else
            {
            System.out.println("Not quite. Guess again. Or enter v to view the solution.\n");
            }
          }
        }
  
      else if (choicenumber == 3) // caesar encode
        {
        input = reader.readLine("Enter the phrase you would like to encode, with words separated by spaces and ending with a period. \n");
        int shift = reader.readInt("Enter the shift of the cipher you would like to encode the quote with.\t\t");
        reader.pause();
        String returning = willy.caesarEncode(input, shift);
        String caps = returning.substring(0, 1).toUpperCase();
        returning = caps + returning.substring(1);
        
        while (!correct)
          {
          guess = reader.readLine("What is the new text? Enter your guess in the same format as the sentence you entered. Only the first letter is capitalized.\n");
          if (guess.equals(returning))
            {
            System.out.println("Congratulations! You correctly encrypted this caesar cipher.\n");
            correct = true;
            }
          else if (guess.equals("v") || guess.equals("V"))
            {
            System.out.println("SOLUTION: \t" + returning);
            correct = true;
            }
          else
            {
            System.out.println("Not quite. Guess again. Or enter v to view the solution.\n");
            }
          }
        }
  
      else if (choicenumber == 4) // caesar decode
        {
        input = reader.readLine("Enter the phrase you would like to decode, with words separated by spaces and ending with a period. \n");
        int shift = reader.readInt("Enter the shift that the encoded cipher used.\t\t");
        reader.pause();
        String returning = willy.caesarDecode(input, shift);
        String caps = returning.substring(0, 1).toUpperCase();
        returning = caps + returning.substring(1);
        
        while (!correct)
          {
          guess = reader.readLine("What is the new text? Enter your guess in the same format as the sentence you entered. Only the first letter is capitalized.\n");
          if (guess.equals(returning))
            {
            System.out.println("Congratulations! You correctly decrypted this caesar cipher.\n");
            correct = true;
            }
          else if (guess.equals("v") || guess.equals("V"))
            {
            System.out.println(returning);
            correct = true;
            }
          else
            {
            System.out.println("Not quite. Guess again. Or enter v to view the solution.\n");
            }
          }
        }
  
      else if (choicenumber == 5) // affine encode
        {
        input = reader.readLine("Enter the phrase you would like to encode, with words separated by spaces and ending with a period. \n");
        int a = reader.readInt("Enter your desired a value.\t\t");
        int b = reader.readInt("Enter your desired b value.\t\t");
        reader.pause();
        String returning = willy.affineEncode(input, a, b);
        String caps = returning.substring(0, 1).toUpperCase();
        returning = caps + returning.substring(1);
        
        while (!correct)
          {
          guess = reader.readLine("What is the new text? Enter your guess in the same format as the sentence you entered. Only the first letter is capitalized.\n");
          if (guess.equals(returning))
            {
            System.out.println("Congratulations! You correctly encrypted this affine cipher.\n");
            correct = true;
            }
          else if (guess.equals("v") || guess.equals("V"))
            {
            System.out.println("SOLUTION: \t" + returning);
            correct = true;
            }
          else
            {
            System.out.println("Not quite. Guess again. Or enter v to view the solution.\n");
            }
          }
      }
        
      else if (choicenumber == 6) // affine decode
        {
        input = reader.readLine("Enter the phrase you would like to decode, with words separated by spaces and ending with a period. \n");
        int a = reader.readInt("Enter the a value of the encryption.\t\t");
        int b = reader.readInt("Enter the b value of the encryption.\t\t");
        reader.pause();
        String returning = willy.affineDecode(input, a, b);
        String caps = returning.substring(0, 1).toUpperCase();
        returning = caps + returning.substring(1);
        
        while (!correct)
          {
          guess = reader.readLine("What is the new text? Enter your guess in the same format as the sentence you entered. Only the first letter is capitalized.\n");
          if (guess.equals(returning))
            {
            System.out.println("Congratulations! You correctly decrypted this affine cipher.\n");
            correct = true;
            }
          else if (guess.equals("v") || guess.equals("V"))
            {
            System.out.println("SOLUTION: \t" + returning);
            correct = true;
            }
          else
            {
            System.out.println("Not quite. Guess again. Or enter v to view the solution.\n");
            }
          }
      }
  
      else if (choicenumber == 7) // vigenere encode
        {
        input = reader.readLine("Enter the phrase you would like to encode, with words separated by spaces and ending with a period. \n");
        keyword = reader.readLine("Enter the keyword you would like to encode the quote with.\t\t");
        String returning = willy.vigenereEncode(input, keyword, 0);
        String caps = returning.substring(0, 1).toUpperCase();
        returning = caps + returning.substring(1);
        
        while (!correct)
          {
          guess = reader.readLine("What is the new text? Enter your guess in the same format as the sentence you entered. Only the first letter is capitalized.\n");
          if (guess.equals(returning))
            {
            System.out.println("Congratulations! You correctly encrypted this vigenere cipher.\n");
            correct = true;
            }
          else if (guess.equals("v") || guess.equals("V"))
            {
            System.out.println("SOLUTION: \t" + returning);
            correct = true;
            }
          else
            {
            System.out.println("Not quite. Guess again. Or enter v to view the solution.\n");
            }
          }
        
        }
      
      else if (choicenumber == 8) // vigenere decode
        {
        input = reader.readLine("Enter the phrase you would like to decode, with words separated by spaces and ending with a period. \n");
        keyword = reader.readLine("Enter the keyword the ciphertext was encoded with. \t\t");
        reader.pause();
        String returning = willy.vigenereDecode(input, keyword, 0);
        String caps = returning.substring(0, 1).toUpperCase();
        returning = caps + returning.substring(1);
        
        while (!correct)
          {
          guess = reader.readLine("What is the new text? Enter your guess in the same format as the sentence you entered. Only the first letter is capitalized.\n");
          if (guess.equals(returning))
            {
            System.out.println("Congratulations! You correctly decrypted this vigenere cipher.\n");
            correct = true;
            }
          else if (guess.equals("v") || guess.equals("V"))
            {
            System.out.println("SOLUTION: \t" + returning);
            correct = true;
            }
          else
            {
            System.out.println("Not quite. Guess again. Or enter v to view the solution.\n");
            }
          }
        }
  
      else if (choicenumber == 9) // 2x2 hill encode
        {
      input = reader.readLine("Enter the phrase you would like to encode as a string with no spaces or punctuation.\n");
      input = input.toLowerCase();
      keyword = reader.readLine("Enter the keyword you would like to encode the plaintext with. Must be 4 characters long.\n");
      keyword = keyword.toLowerCase();
      if (keyword.length() != 4)
        System.out.println("Invalid, try again later!");
      else
        {
        String returning = willy.hillEncode(input, keyword);
        returning = returning.toUpperCase();
        
        
        while (!correct)
          {
          guess = reader.readLine("What is the new text? Enter your guess in the same format as the sentence you entered. Only the first letter is capitalized.\n");
          guess = guess.toUpperCase();
          if (guess.equals(returning))
            {
            System.out.println("Congratulations! You correctly encrypted this 2x2 hill cipher.\n");
            correct = true;
            }
          else if (guess.equals("V"))
            {
            System.out.println("SOLUTION: \t" + returning);
            correct = true;
            }
          else
            {
            System.out.println("Not quite. Guess again. Or enter v to view the solution.\n");
            }
          }
        }
        
      }
  
      else if (choicenumber == 10) // 2x2 hill decode
        {
      input = reader.readLine("Enter the phrase you would like to decode as a string with no spaces or punctuation. Be careful: your ciphertext must have an even number of letters otherwise a z will be appended and the last letter may be incorrect. \n");
      input = input.toLowerCase();
      keyword = reader.readLine("Enter the keyword that was used to encode the quote. Must be 4 characters long. \n");
      keyword = keyword.toLowerCase();
      if (keyword.length() != 4)
        System.out.println("Invalid, try again later!");
      else
        {
        String returning = willy.hillDecode(input, keyword);
        returning = returning.toUpperCase();
        
        while (!correct)
          {
          guess = reader.readLine("What is the new text? Enter your guess in the same format as the sentence you entered. Only the first letter is capitalized.\n");
          guess = guess.toUpperCase();
          if (guess.equals(returning))
            {
            System.out.println("Congratulations! You correctly decrypted this 2x2 hill cipher.\n");
            correct = true;
            }
          else if (guess.equals("V"))
            {
            System.out.println("SOLUTION: \t" + returning);
            correct = true;
            }
          else
            {
            System.out.println("Not quite. Guess again. Or enter v to view the solution.\n");
            }
          }
        }
      }
      
      else if (choicenumber == 11) // porta encode
        {
        input = reader.readLine("Enter the text you would like to encode, with words separated by spaces and ending with a period.\t\t");
        keyword = reader.readLine("Enter the keyword you would like to encode the text with. \t\t");
        reader.pause();
        
        String returning = willy.portaSolve(input, keyword, 0);
        String caps = returning.substring(0, 1).toUpperCase();
        returning = caps + returning.substring(1);
        
        while (!correct)
          {
          guess = reader.readLine("What is the new text? Enter your guess in the same format as the sentence you entered. Only the first letter is capitalized.\n");
          if (guess.equals(returning))
            {
            System.out.println("Congratulations! You correctly encrypted this porta cipher.\n");
            correct = true;
            }
          else if (guess.equals("v") || guess.equals("V"))
            {
            System.out.println("SOLUTION: \t" + returning);
            correct = true;
            }
          else
            {
            System.out.println("Not quite. Guess again. Or enter v to view the solution.\n");
            }
          }
        }
      
      else if (choicenumber == 12) // porta decode
        {
        input = reader.readLine("Enter the text you would like to decoded, with words separated by spaces and ending with a period.");
        keyword = reader.readLine("Enter the keyword the ciphertext was encoded with. \t\t");
        reader.pause();
        
        String returning = willy.portaSolve(input, keyword, 0);
        String caps = returning.substring(0, 1).toUpperCase();
        returning = caps + returning.substring(1);
        
        while (!correct)
          {
          guess = reader.readLine("What is the new text? Enter your guess in the same format as the sentence you entered. Only the first letter is capitalized.\n");
          if (guess.equals(returning))
            {
            System.out.println("Congratulations! You correctly decrypted this porta cipher.\n");
            correct = true;
            }
          else if (guess.equals("v") || guess.equals("V"))
            {
            System.out.println("SOLUTION: \t" + returning);
            correct = true;
            }
          else
            {
            System.out.println("Not quite. Guess again. Or enter v to view the solution.\n");
            }
          }
      }
      
      else if (choicenumber == 13) // tester
        {
      String str = "teach a man to reason and he will think for a lifetime.";
      System.out.println(willy.portaSolve(str, "microwave", 0));
      String str2 = "gwr wsfe jvk gm cjsqxpl kbfe nggfez wf eb xdrpgz wg.";
      System.out.println(willy.portaSolve(str2, "beard", 0));
      }
      
      else if (choicenumber == 14) // 3x3 hill encode NOT FUNCTIONAL
        {
      input = reader.readLine("Enter the text you would like to encode without spaces and punctuation.");
      keyword = reader.readLine("Enter the keyword the ciphertext to encode with. (9 characters)\t\t");
      reader.pause();
        
        String returning = willy.hillthreebythreeencode(input, keyword);
        String caps = returning.substring(0, 1).toUpperCase();
        returning = caps + returning.substring(1);
        System.out.println(returning);

        while (!correct)
        {
        guess = reader.readLine("What is the new text? Enter your guess in the same format as the sentence you entered. Only the first letter is capitalized.\n");
        if (guess.equals(returning))
          {
          System.out.println("Congratulations! You correctly decrypted this porta cipher.\n");
          correct = true;
          }
        else if (guess.equals("v") || guess.equals("V"))
          {
          System.out.println("SOLUTION: \t" + returning);
          correct = true;
          }
        else
          {
          System.out.println("Not quite. Guess again. Or enter v to view the solution.\n");
          }
        }

      }
      
      else if (choicenumber == 15) // 3x3 hill decode NOT FUNCTIONAL
        {
      input = reader.readLine("Enter the text you would like to decoded without spaces and punctuation.");
      keyword = reader.readLine("Enter the keyword the ciphertext to encode with. (9 characters)\t\t");
      reader.pause();  
      String returning = willy.hillthreebythreeencode(input, keyword);
      String caps = returning.substring(0, 1).toUpperCase();
      returning = caps + returning.substring(1);
      System.out.println(returning);

      while (!correct)
          {
          guess = reader.readLine("What is the new text? Enter your guess in the same format as the sentence you entered. Only the first letter is capitalized.\n");
          if (guess.equals(returning))
            {
            System.out.println("Congratulations! You correctly decrypted this porta cipher.\n");
            correct = true;
            }
          else if (guess.equals("v") || guess.equals("V"))
            {
            System.out.println("SOLUTION: \t" + returning);
            correct = true;
            }
          else
            {
            System.out.println("Not quite. Guess again. Or enter v to view the solution.\n");
            }
          }
      }
      
      else if (choicenumber == 16) // aristocrat helper
      {
      input = reader.readLine("Enter the aristocrat you would like to decode:\t");
      boolean[] changed = new boolean[input.length()];
      while (!correct)
        {
          String sub = "";
          String orig = "";
          sub = reader.readLine("Enter the letter you want to substitute: \t");
          orig = reader.readLine("Enter the letter you want to substitute it for: \t");
          int a = reader.readInt("Is this a change to a letter you already tried to decode? Enter 1 for yes, enter any other number for no.\t");
          if (a == 1)
            input = willy.aristocrat(input, orig, sub, changed, true);
          else
            input = willy.aristocrat(input, orig, sub, changed, false);
          System.out.println(input);
          int solved = reader.readInt("Is this correct? Enter 1 if yes:\t");
          if (solved == 1)
            correct = true;
        }

      }
      else if (choicenumber == 17) // xenocrypt helper
      {
      input = reader.readLine("Enter the xenocrypt you would like to decode. Note that you will have to copy an accented n when decoding.:\t");
      boolean[] changed = new boolean[input.length()];
      while (!correct)
        {
          String sub = "";
          String orig = "";
          sub = reader.readLine("Enter the letter you want to substitute: \t");
          orig = reader.readLine("Enter the letter you want to substitute it for: \t");
          int a = reader.readInt("Is this a change to a letter you already tried to decode? Enter 1 for yes, enter any other number for no.\t");
          if (a == 1)
            input = willy.aristocrat(input, orig, sub, changed, true);
          else
            input = willy.aristocrat(input, orig, sub, changed, false);
          System.out.println(input);
          int solved = reader.readInt("Is this correct? Enter 1 if yes:\t");
          if (solved == 1)
            correct = true;
        }

      }
      else if (choicenumber == 18) // patristocrat helper 
      {
        input = reader.readLine("Enter the patristocrat you would like to decode:\t");
      boolean[] changed = new boolean[input.length()];
      while (!correct)
        {
          String sub = "";
          String orig = "";
          sub = reader.readLine("Enter the letter you want to substitute: \t");
          orig = reader.readLine("Enter the letter you want to substitute it for: \t");
          int a = reader.readInt("Is this a change to a letter you already tried to decode? Enter 1 for yes, enter any other number for no.\t");
          if (a == 1)
            input = willy.aristocrat(input, orig, sub, changed, true);
          else
            input = willy.aristocrat(input, orig, sub, changed, false);
          System.out.println(input);
          int solved = reader.readInt("Is this correct? Enter 1 if yes:\t");
          if (solved == 1)
            correct = true;
        }

      }
      else if (choicenumber == 19) // K1 helper
      {
        input = reader.readLine("Enter the K1 cipher (aristocrat, patristocrat, xenocrypt) you would like to decode:\t");
        input = input.toUpperCase();
        boolean[] changed = new boolean[input.length()];
        String[] regAlpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for (int i = 0; i < 26; i++)
          regAlpha[i] = regAlpha[i].toUpperCase();
        String[] decrypted = new String[26];
        for (int i = 0; i < 26; i++)
          decrypted[i] = "_";
        int[] frequency = new int[26];
        for (int i = 0; i < frequency.length; i++)
          {
          for (int j = 0; j < input.length(); j++)
            {
              if (input.substring(j, j+1).equals(regAlpha[i]))
                frequency[i]++;
            }
          }
        while (!correct)
          {
            String sub = "";
            String orig = "";
            sub = reader.readLine("Enter the letter you want to substitute: \t");
            sub = sub.toUpperCase();
            orig = reader.readLine("Enter the letter you want to substitute it for: \t");
            orig = orig.toUpperCase();
            for (int i = 0; i < 26; i++)
              {
              if (orig.equals(regAlpha[i]))
                decrypted[i] = sub;
              }
            int a = reader.readInt("Is this a change to a letter you already tried to decode? Enter 1 for yes, enter any other number for no.\t");
            if (a == 1)
              input = willy.aristocrat(input, orig, sub, changed, true);
            else
              input = willy.aristocrat(input, orig, sub, changed, false);
            System.out.println(input);
            System.out.print("K1 Alphabet: ");
            for (int j = 0; j < 26; j++)
              {
              System.out.print(regAlpha[j] + " ");
              }
            System.out.println();
            System.out.print("Frequency:   ");
            for (int j = 0; j < 26; j++)
              {
              System.out.print(frequency[j] + " ");
              }
            System.out.println();
            System.out.print("Replacement: ");
            for (int j = 0; j < 26; j++)
              {
              System.out.print(decrypted[j] + " ");
              }
            int solved = reader.readInt("Have you found the keyword yet? Enter 1 if yes:\t");
            if (solved == 1)
              correct = true;
          }
      }
      else if (choicenumber == 20) // K2 helper
      {
        input = reader.readLine("Enter the K2 cipher (aristocrat, patristocrat, xenocrypt) you would like to decode:\t");
        input = input.toUpperCase();
        boolean[] changed = new boolean[input.length()];
        String[] regAlpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for (int i = 0; i < 26; i++)
          regAlpha[i] = regAlpha[i].toUpperCase();
        String[] decrypted = new String[26];
        for (int i = 0; i < 26; i++)
          decrypted[i] = "_";
        int[] frequency = new int[26];
        for (int i = 0; i < frequency.length; i++)
          {
          for (int j = 0; j < input.length(); j++)
            {
              if (input.substring(j, j+1).equals(regAlpha[i]))
                frequency[i]++;
            }
          }
        while (!correct)
          {
            String sub = "";
            String orig = "";
            sub = reader.readLine("Enter the letter you want to substitute: \t");
            sub = sub.toUpperCase();
            orig = reader.readLine("Enter the letter you want to substitute it for: \t");
            orig = orig.toUpperCase();
            for (int i = 0; i < 26; i++)
              {
              if (sub.equals(regAlpha[i]))
                decrypted[i] = orig;
              }
            int a = reader.readInt("Is this a change to a letter you already tried to decode? Enter 1 for yes, enter any other number for no.\t");
            if (a == 1)
              input = willy.aristocrat(input, orig, sub, changed, true);
            else
              input = willy.aristocrat(input, orig, sub, changed, false);
            System.out.println(input);
            System.out.print("Replacement: ");
            for (int j = 0; j < 26; j++)
              {
              System.out.print(decrypted[j] + " ");
              }
            System.out.println();
            System.out.print("K2 Alphabet: ");
            for (int j = 0; j < 26; j++)
              {
              System.out.print(regAlpha[j] + " ");
              }
            System.out.println();
            System.out.print("Frequency:   ");
            for (int j = 0; j < 26; j++)
              {
              System.out.print(frequency[j] + " ");
              }
            
            int solved = reader.readInt("Have you found the keyword yet? Enter 1 if yes:\t");
            if (solved == 1)
              correct = true;
          }
      }
      else if (choicenumber == 420)
        System.out.println("You exited the code program, what a loser");
      else
        System.out.println("Invalid number lol");


      
      }
  
  
  
    }
  
    
  }