#!/bin/sh

./../CRF++-0.58/crf_learn template.txt train.txt model.txt
./../CRF++-0.58/crf_ignore/CRF++-0.58/crf_test  model.txt test.txt