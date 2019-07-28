#!/bin/bash

echo "Useage: ./_.sh <ore> <location>  "
# for example, ./cloneBlock.sh gold end

# I just happened to make granite first
dest="ore_$1_$2"

echo "$dest.json"

original="ore_gold_nether" # becomes destination

modid="elementaryores"
folder="src/main/resources/assets/${modid}"

folderdata="src/main/resources/data/${modid}"

# create the files


cp "${folderdata}"/loot_tables/blocks/${original}.json "${folderdata}"/loot_tables/blocks/"${dest}".json

cp "${folderdata}"/recipes/${original}.json "${folderdata}"/recipes/"${dest}".json


cp "${folder}"/blockstates/"${original}".json "${folder}"/blockstates/"${dest}".json

cp "${folder}"/models/block/"${original}".json "${folder}"/models/block/"${dest}".json


cp "${folder}"/models/item/"${original}".json "${folder}"/models/item/"${dest}".json


# replace texture in block model so thi
#sed -i -e "s/${oldtexture}/${newtexture}/g" "${folder}"/models/block/"${dest}".json


sed -i -e "s/${original}/${dest}/g" "${folderdata}"/recipes/"${dest}".json
sed -i -e "s/${original}/${dest}/g" "${folderdata}"/loot_tables/blocks/"${dest}".json

sed -i -e "s/${original}/${dest}/g" "${folder}"/models/item/"${dest}".json

sed -i -e "s/${original}/${dest}/g" "${folder}"/models/block/"${dest}".json

sed -i -e "s/${original}/${dest}/g" "${folder}"/blockstates/"${dest}".json
    

echo "files written dest.json"
