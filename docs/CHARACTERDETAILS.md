Usage
=====

### Note :
This module is still under development and this document presently shows only currently available utilities.

### CharacterDetailsObject
This class following fields
```
        boolean isDigit               - return true if character is digit else false
        boolean isAlphabet            - return true if character is alphabet else false
        boolean isAlphaNumeric        - return true if character is alphanumeric else false
        int htmlEntity                - HTML entity code
        String name                   - name of character
        String codePoint              - unicode code point
        String canonicalDecomposition - canonical decomposition        
```

#### Get all character details of single character  
```
        CharacterDetails obj = new CharacterDetails();
        CharacterDetailsObject details = obj.getCharacterDetails('A');        
```
The above function `obj.getCharacterDetails(char);` accepts unicode character and outputs details of character. 


#### Get all character details of characters of text in array 
```
        CharacterDetails obj = new CharacterDetails();
        CharacterDetailsObject[] arr = obj.getCharacterDetailsAsArray("$V.");
```
The above function `obj.getCharacterDetailsAsArray(String);` accepts unicode string and outputs details of characters in an array in given order of characters. 


#### Get all character details of characters of text in a map 
```
        CharacterDetails obj = new CharacterDetails();
        Map<Character, CharacterDetailsObject> map = obj.getCharacterDetailsAsMap("$V.");        
```
The above function `obj.getCharacterDetailsAsMap(String);` accepts unicode string and outputs details of characters in a map.


#### Get module name and information
```
        String moduleName = obj.getModuleName();
        String moduleInforamtion =  obj.getModuleInformation();
```

#### To run tests

  - Select test to run
  - Right Click -> Run Test -> Run as Android Test

