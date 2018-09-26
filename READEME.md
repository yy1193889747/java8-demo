# Java基础

- [ ] 设计模式
- [ ] 位与运算
- [ ] jvm
- [ ] 多线程
- [ ] java8特性

##  
* 逻辑CPU个数 > 物理CPU个数 * CPU内核数   开启了超线程   
* 逻辑CPU个数 = 物理CPU个数 * CPU内核数   没有开启超线程
```
#!/bin/bash

physicalNumber=0
coreNumber=0
logicalNumber=0
HTNumber=0

logicalNumber=$(grep processor /proc/cpuinfo | sort -u | wc -l)
physicalNumber=$(grep "physical id" /proc/cpuinfo | sort -u| wc -l)
coreNumber=$(grep "cpu cores" /proc/cpuinfo | uniq | awk -F ':' '{print $2}' | xargs)
HTNumber=$((logicalNumber / (physicalNumber * coreNumber)))

echo "****** CPU Information ******"
echo "Logical CPU Number  : ${logicalNumber}"
echo "Physical CPU Number : ${physicalNumber}"
echo "CPU Core Number     : ${coreNumber}"
echo "HT Number           : ${HTNumber}"
echo "*****************************"