# Silent Eight homework - Gender Endpoint
Scroll to the bottom for requirements.

## v1 Examples
    GET http://localhost:8080/v1?name=maria
    RETURNS {"gender":"Female"}

    GET http://localhost:8080/v1?name=jan
    RETURNS {"gender":"Male"}
    
    http://localhost:8080/v1?name=123
    RETURNS {"gender":"Inconclusive"}

## Business Requirements
Create a simple Java application, that can detect gender by given name. Guess gender detection algorithm is fairly simple and is based on a list of female and male tokens, that should be packaged within JAR. Those lists should be in the form of two flat files, where each line contains a separate token. For each name, the app responds either with gender or “INCONCLUSIVE”. The gender detection algorithm should be implemented in two variants: 

    Only first token of name is checked: 
        Example: female tokens list = [“Maria”], male tokens list = [“Jan”]. Given name “Jan Maria Rokita”, algorithm concludes “MALE” gender, because only Jan is checked
    All tokens are checked and majority rule is used:
        Example: female tokens list =  [“Maria”],  male tokens list =  [“Jan”]. Given the name “Jan Maria Rokita”, the algorithm responds with “INCONCLUSIVE”. Jan is in male tokens list, Maria is in the female tokens list and Rokita is not found. Therefore no unambiguous conclusion could be found.
        Example: female tokens list = [“Anna”, “Gertruda”], male tokens list = [“Zbigniew”]. Given name: “Anna Zbigniew Gertruda” algorithm responds with Female guessed gender, because 2 tokens for female > 1 token for male.

Application should expose two HTTP endpoints: one for using the gender guessing with selected variant and one for returning available tokens for each gender. First endpoint accepts a name as a single string.

## Technical requirements:

- [x] Use Java and JDK >= 11
- [x] Use Gradle (preferable) or Maven to provide a task that builds JAR that is runnable on its own.
- [x] Apart from the above, any frameworks and libraries are permitted.
- [ ] Code should be well tested
- [x] Code should be provided in a form of a link to a git repository.
- [ ] Don’t load token lists into memory, as it could be very huge.
- [ ] Make algorithm (not to be confused with the whole app) versionable.
- [ ] Make it easily runnable through docker.
