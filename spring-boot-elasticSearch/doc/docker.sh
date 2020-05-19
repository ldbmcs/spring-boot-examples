docker run -name elasticsearch -d -e ES_JAVA_OPTS="-Xms512m -Xmx512m" -p 9200:9200 -p 9300:9300 docker.elastic.co/elasticsearch/elasticsearch:6.2.2

docker run -d -p 9100:9100 docker.io/mobz/elasticsearch-head:5