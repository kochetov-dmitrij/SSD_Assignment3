package gui;

/**
 * Window class containing the view to be displayed and provides basic operations on it
 */
public class Window {
    BaseView view;

    public void displayContent(){
        // Some magic
        view.display();
        // More magic
    }

    private void removeDecorator(String decoratorType){
        BaseView prevView = null;
        BaseView currView = view;
        while (currView instanceof ViewDecorator){
            switch (decoratorType){
                case "FilterView":
                    if (currView instanceof FilterView){
                        if (prevView == null){
                            this.view = ((FilterView) currView).originalView;
                        } else {
                            ((ViewDecorator) prevView).originalView = ((FilterView) currView).originalView;
                        }
                    }
                    break;
                case "HistoryView":
                    if (currView instanceof HistoryView){
                        if (prevView == null){
                            this.view = ((HistoryView) currView).originalView;
                        } else {
                            ((ViewDecorator) prevView).originalView = ((HistoryView) currView).originalView;
                        }
                    }
                    break;
            }
            prevView = currView;
            currView = ((ViewDecorator) currView).getOriginalView();
        }
    }

    public void hideFiltersPanel(){
        removeDecorator("FilterView");
    }

    public void hideHistoryPanel(){
        removeDecorator("HistoryView");
    }

    public void addFiltersPanel(){
        this.view = new FilterView(this.view);
    }

    public void addHistoryPanel(){
        this.view = new HistoryView(this.view);
    }

    public Window(BaseView view) {
        this.view = view;
    }
}
