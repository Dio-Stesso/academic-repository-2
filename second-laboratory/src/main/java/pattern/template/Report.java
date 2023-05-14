package pattern.template;

import pattern.singleton.Library;

public abstract class Report {
    public void generate(Library library) {
        // common report generation code
        printHeader();
        printBody(library);
        printFooter();
    }

    protected abstract void printHeader();
    protected abstract void printBody(Library library);
    protected abstract void printFooter();
}
