import time

def findX(x):
    return dSets[x]

def mergeSet(p,q):
    lis=hashSet[q]
    for i in lis:
        dSets[i]=p
        hashSet[p].append(i)
    del hashSet[q]

n=1000000
dSets =[]
for i in range(0,n):
    dSets.append(i)
hashSet={}
for i in range(0,n):
    hashSet[i]=[i]
edgeSet=[]
fh= open("Graph.txt","r")
for k in fh:
    a,b=k.split(',')
    a=int(a)
    b=int(b)
    #print(a,b)
    c,d=findX(a),findX(b)
    if c!=d:
        p=min(c,d)
        q=max(c,d)
        mergeSet(p,q)

#by cal
clusters = {}
individuals = []

for x in dSets:
    if x not in clusters:
        clusters[x] = 1
    else:
        clusters[x] += 1

for key in list(clusters):
    if clusters[key] == 1:
        individuals.append(clusters[key])
        del clusters[key]

print("Number of clusters: ", len(clusters))
print("Number of individuals: ", len(individuals))

clusterSizes = []
for key in clusters:
    clusterSizes.append(clusters[key])

clusterSizes=sorted(clusterSizes, key=int, reverse=True)
print("Sizes of 5 largest clusters: ", clusterSizes[0:5])


print(findX(825289)==findX(891950))
print(findX(1)==findX(267721))
print(findX(785775)==findX(891950))
print(findX(733252)==findX(891950))
print(findX(250429)==findX(2))
#for i in dSets:
    #print(i)
#for k,v in hashSet.items():
    #print(k,v)
fh.close()
