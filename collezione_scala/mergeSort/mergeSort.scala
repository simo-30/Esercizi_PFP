object mergeSort {
	def merge (a:List[Int], b:List[Int]):List[Int] = {
		if (a==Nil) b
		else if (b==Nil) a
		else if (a.head < b.head) a.head :: merge(a.tail, b)
		else b.head :: merge(a, b.tail)
	}
	
	def merge_sort(v:List[Int]):List[Int] = {
		if (v.length < 2) v
		else {
			val (l,r) = v.splitAt(v.length/2)
			merge(merge_sort(l), merge_sort(r))
		}
	}
} 
