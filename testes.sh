curl -XGET 'http://172.16.1.30:9200/meila_wares/wares/_search?pretty' -d '
{"from": 0,
 "query": {"match": {"name": {"operator": "or",
    "query": "玛尔斯"}}},
 "size": 100}'
