import java.util.ArrayList;

public class AdvCSStack<T> implements GenStackInterface<T> {

    // Shayan Daijavad Implemented Stack from GenStackInterface 8/22/19

    private ArrayList<T> list;

    // Constructs a stack
    public AdvCSStack()
    {
        list = new ArrayList<T>();
    }

    // Adds to stack
    public void push(T y)
    {
        list.add(y);
    }


    // Removes top element from stack
    public T pop()
    {
        return list.remove(list.size() - 1);
    }


    // Looks at top element
    public T peek()
    {
        return list.get(list.size() - 1);
    }


    // Checks if stack is empty
    public boolean isEmpty()
    {
        if(list.size() == 0)
        {
            return true;
        }
        else
            return false;
    }

    public AdvCSStack copy()
    {
        AdvCSStack<T> copy = new AdvCSStack<T>();
        AdvCSStack<T> copytwo = new AdvCSStack<T>();
        T x;

        while (!this.isEmpty())
        {
            copy.push(this.pop());
        }

        while (!copy.isEmpty())
        {
            x = copy.pop();
            this.push(x);
            copytwo.push(x);
        }

        return copytwo;
    }

    public String toString() {
        return list.toString();
    }
}
