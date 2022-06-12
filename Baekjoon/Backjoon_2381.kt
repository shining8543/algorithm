import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*



    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st : StringTokenizer

        var N = Integer.parseInt(br.readLine())

        var aList = mutableListOf<Int>()
        var bList = mutableListOf<Int>()



        for(i in 0 .. N-1){
            st = StringTokenizer(br.readLine())
            var x = Integer.parseInt(st.nextToken())
            var y = Integer.parseInt(st.nextToken())

            aList.add(x + y)
            bList.add(x - y)


        }

        aList.sort()
        bList.sort()


        var answer = kotlin.math.max(aList.get(N-1) - aList.get(0) , bList.get(N-1) - bList.get(0))

        println(answer)















    }

