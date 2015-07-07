#!/bin/sh

../../crf_learn template.txt train.txt model.txt
../../crf_test  model.txt test.txt