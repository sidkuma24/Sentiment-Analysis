#!/bin/sh

#get all the text from anntattion xml
javac GetTokensFromXML.java && java GetTokensFromXML ../../data/annotated/annotated_siddharth_final/Annotation_sid.xml

#get all the tokens and aspect terms from xml
javac GetTextFromXML.java && java GetTextFromXML ../../data/annotated/annotated_siddharth_final/Annotation_sid.xml

#get the class values for the tokesn 0, B_ASP, I_ASP
javac GetClassFromXML.java && java GetClassFromXML ../../data/annotated/annotated_siddharth_final/Annotation_sid.xml

#combine features to get the final data file

#divide into train and test data
