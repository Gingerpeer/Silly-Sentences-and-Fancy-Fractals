/*
 * Silly Sentences and Fancy Fractals: 
 * To Do List:
 * Write a program that generates random sentences based on a set of syntax rules.
 * Implement syntax rules for 
 * sentence = simple sentence + noun phrase + verb phrase + conjunction + proper noun + common noun + determiner + adjective + intransitive verb + transitive verb.
 * simple sentence = noun phrase + verb phrase.
 * noun phrase = determiner + adjective + common noun.
 * Write a subroutine for each of the first three rules: sentence, simple sentence, and noun phrase.
 * Use arrays to implement the last seven rules.
 * Use a switch or if-else statement to handle alternatives and an if statement to handle optional elements.
 * Use a while loop to handle repeated optional elements.
 * Call the sentence subroutine to generate random sentences.
 * Adjust probabilities to avoid infinite recursion.
 * Create pictures of fractals using recursion.
 */

 // random number generator
import java.util.Random;

public class SillySentences {
    private static final Random rand = new Random();

    private static final String[] properNouns = {
        "Fred", "Jane", "Richard Nixon", "Miss America"
    };

    private static final String[] commonNouns = {
        "man", "woman", "fish", "elephant", "unicorn"
    };

    private static final String[] determiners = {
        "a", "the", "every", "some"
    };

    private static final String[] adjectives = {
        "big", "tiny", "pretty", "bald"
    };

    private static final String[] intransitiveVerbs = {
        "runs", "jumps", "talks", "sleeps"
    };

    private static final String[] transitiveVerbs = {
        "loves", "hates", "sees", "knows", "looks for", "finds"
    };

    private static final String[] conjunctions = {
        "and", "or", "but", "because"
    };

    private static String randomItem(String[] list) {
        int i = rand.nextInt(list.length);
        return list[i];
    }

    private static String properNoun() {
        return randomItem(properNouns);
    }

    private static String commonNoun() {
        return randomItem(commonNouns);
    }
    private static String determiner() {
        return randomItem(determiners);
    }
    private static String adjective() {
        return randomItem(adjectives);
    }
    private static String intransitiveVerb() {
        return randomItem(intransitiveVerbs);
    }
    private static String transitiveVerb() {
        return randomItem(transitiveVerbs);
    }
    private static String conjunction() {
        return randomItem(conjunctions);
    }
    // <noun_phrase> ::= <proper_noun> | <determiner> [ <adjective> ]. <common_noun> [ who <verb_phrase> ]
    private static String nounPhrase() {
        String[] NounPhraseOptions = {
            properNoun(),
            determiner() + " " + adjective() + " . " + commonNoun() + " who " + verbPhrase(),
        };
        String NounString = randomItem(NounPhraseOptions);
        return NounString;
    }
    // <verb_phrase> ::= <intransitive_verb> | <transitive_verb> <noun_phrase>| is <adjective> | believes that <simple_sentence>
    private static String verbPhrase() {
        String[] VerbPhraseOptions = {
            intransitiveVerb(),
            transitiveVerb() + " " + nounPhrase(),
            "is " + adjective(),
            "believes that " + simpleSentence(),
        };
        String VerbString = randomItem(VerbPhraseOptions);
        return VerbString;
    }
    private static String simpleSentence() {
        return nounPhrase() + " " + verbPhrase();
    }
    // sentence = simple sentence + noun phrase + verb phrase + conjunction + proper noun + common noun + determiner + adjective + intransitive verb + transitive verb.
    private static String sentence() {
        return simpleSentence() + " " + nounPhrase() + " " + verbPhrase() + " " + conjunction() + " " + properNoun() + " " + commonNoun() + " " + determiner() + " " + adjective() + " " + intransitiveVerb() + " " + transitiveVerb();
    }
    // create a main method to test the methods
    public static void main(String[] args) {
        System.out.println(sentence());
    }
  }