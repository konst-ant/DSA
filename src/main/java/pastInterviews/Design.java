package pastInterviews;

/**
 * Implement validation rules for replaceWith and addPage methods -
 * sizeCheck and sameFontCheck (no two pages could have same fonts)
 */

import java.util.List;

record Design(int width, int height, List<Page> pages) {
}

record Page(String id, List<Element> elements) {
}

record Element(String id, int width, int height, String font) {
}

interface DesignUpdater {
    /**
     * Replaces the entire design with the provided design.
     * @return true if successful, false if the design was not replaced.
     */
    boolean replaceWith(Design newDesign);

    /**
     * Adds the provided page to the existing design
     * @return true if successful, false if the design was not updated.
     */
    boolean addPage(Page newPage);
}


class DesignUpdaterImpl implements DesignUpdater {
    public Design currentDesign = new Design(1000, 1000, List.of());

    @Override
    public boolean replaceWith(Design newDesign) {

        if (validate(newDesign)) {
            currentDesign = newDesign;
            return true;
        }

        return false;
    }

    @Override
    public boolean addPage(Page newPage) {
        if (validate(newPage, currentDesign)) {
            currentDesign.pages().add(newPage);
            return true;
        }

        return false;
    }

    private boolean validate(Design design) {
        boolean validDesignSize = design.width() < currentDesign.width() && design.height() < currentDesign.height();

        boolean validSize = design.pages().stream()
                .flatMap(p -> p.elements().stream())
                .allMatch(e -> e.height() < design.height() && e.width() < design.width());

        boolean validFont = design.pages().stream()
                .flatMap(p -> p.elements().stream()).map(Element::font).distinct().count() == 1;
        return validDesignSize && validSize && validFont;
    }

    private boolean validate(Page page, Design design) {
        boolean validSize = page.elements().stream()
                .allMatch(e -> e.height() < design.height() && e.width() < design.width());

        boolean validFont = page.elements().stream()
                .map(e -> e.font()).distinct().count() == 1;

        return validSize && validFont;
    }
}