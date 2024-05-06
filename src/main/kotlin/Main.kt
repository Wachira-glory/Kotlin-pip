fun main(args: Array<String>) {
    val pageVisitTracker = PageVisitTracker()
    val pages = listOf("home", "about", "contact", "sales",)
    pages.forEach { pageVisitTracker.trackPageVisit(it) }

    val topVisitedPages = pageVisitTracker.getTopPages()
    println("Top 5 most visited pages")

    topVisitedPages.forEachIndexed { index, pair ->
        println("${index + 1}. ${pair.first} was visited ${pair.second} times")
    }
}
class PageVisitTracker {
    private val pageVisits = mutableMapOf<String, Int>()

    fun trackPageVisit(page: String) {
        pageVisits[page] = pageVisits.getOrDefault(page, 0) + 1
    }

    fun getTopPages(): List<Pair<String, Int>> {
        return pageVisits.toList().sortedByDescending { it.second }.take(5)
    }
}