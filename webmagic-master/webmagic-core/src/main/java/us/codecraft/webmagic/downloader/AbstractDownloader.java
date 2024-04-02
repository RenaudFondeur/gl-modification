package us.codecraft.webmagic.downloader;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.selector.Html;

/**
 * Base class of downloader with some common methods.
 *
 * @author code4crafter@gmail.com
 * @since 0.5.0
 */
public abstract class AbstractDownloader implements Downloader {

    /**
     * A simple method to download a url.
     *
     * @param url url
     * @return html
     */
    public Html download(String url) {
        return download(url, null);
    }

    /**
     * A simple method to download a url.
     *
     * @param url     url
     * @param charset charset
     * @return html
     */
    public Html download(String url, String charset) {
        Page page = download(new Request(url), Site.me().setCharset(charset).toTask());
        return (Html) page.getHtml();
    }

    /**
     * @param page the {@link Page}.
     * @param task the {@link Task}.
     * @since 0.10.0
     */
    protected void onSuccess(Page page, Task task) {
    }

    /**
     * @param page the {@link Page}.
     * @param task the {@link Task}.
     * @param e the exception.
     * @since 0.10.0
     */
    protected void onError(Page page, Task task, Throwable e) {
    }

}
