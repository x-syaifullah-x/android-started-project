import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Test

class ExampleFragmentTest : Fragment() {

    companion object {
        private const val CONTAINER_ID = 12121
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ConstraintLayout(
        container?.context ?: throw NullPointerException(),
    ).apply { id = CONTAINER_ID }


    @Test
    fun test() {
        launchFragmentInContainer<ExampleFragmentTest>()
        Espresso
            .onView(ViewMatchers.withId(CONTAINER_ID))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}