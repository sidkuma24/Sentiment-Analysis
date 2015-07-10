#token length
cd token_length/
javac featurelength.java && java featurelength ../../../../data/sentiment/features/class.txt
cd ../
echo created feature length
#prefix and suffix
cd prefix_suffix
javac prefix_suffix.java && java prefix_suffix
cd ../
echo created prefix and suffix
#frequent aspect terms
cd aspect_term_list
javac AspectTermFreq.java && java AspectTermFreq
javac AspectTermFreq2.java && java AspectTermFreq2
cd ../
echo created frequent aspect term list
#stop words
cd stop_words
javac StopWords.java && java StopWords 
cd ../
echo created stop words tokens
#n grams till pentagram
cd n-gram
javac modifyTokens.java && java modifyTokens 6
javac nGrams.java && java nGrams 1
javac modifyTokens.java && java modifyTokens 7
javac nGrams.java && java nGrams 2
javac modifyTokens.java && java modifyTokens 8
javac nGrams.java && java nGrams 3
javac modifyTokens.java && java modifyTokens 9
javac nGrams.java && java nGrams 4
javac modifyTokens.java && java modifyTokens 10
javac nGrams.java && java nGrams 5
cd ../
echo created ngrams till pentagram

#local context
cd local_context
javac localContext.java && java localContext 4
cd ../
echo created local context
