#!/bin/sh

#combine all the manually annotated files
cd ../../data/annotated/annotated_siddharth_final/
cat *.txt > id_all.txt
cd ../../../programs/annotation/
#generate xml for the combined file
javac CreateXML.java && java CreateXML ../../data/annotated/annotated_siddharth_final/id_all.txt 
mv Annotation_sid.xml ../../data/annotated/annotated_siddharth_final/Annotation_sid.xml

