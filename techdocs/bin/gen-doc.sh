#!/usr/bin/env bash

# Calc where we are
BIN=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
PROJECT="$( cd "${BIN}/.." && pwd )"

# The "document root" is in /docs one level ABOVE this project
OUTROOT="$( cd "${PROJECT}/.." && pwd )"/docs

# Find out the name of the document (the first artifactId) from the maven file
cd ${PROJECT}
DOCNAME="$(grep -oP -m1 '(?<=artifactId>)[\w-]+(?=\<)' pom.xml)"
OUTDIR=${OUTROOT}/${DOCNAME}

# Make sure the requisite directories have been created
mkdir -p ${OUTDIR}
rm -rf ${OUTDIR}/*

# Generate the new docs
mvn clean && mvn -e generate-resources

# Clean up leftover
rm -rf ${OUTDIR}/.asciidoctor