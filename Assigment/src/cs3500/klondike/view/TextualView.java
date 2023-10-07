package cs3500.klondike.view;

import java.io.IOException;

public interface TextualView {
	/**
	   * Renders a model in some manner (e.g. as text, or as graphics, etc.).
	   * @throws IOException if the rendering fails for some reason
	   */
	  String render() throws IOException;
}