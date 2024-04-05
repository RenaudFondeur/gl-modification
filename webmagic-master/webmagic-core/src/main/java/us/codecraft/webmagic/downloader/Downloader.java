package us.codecraft.webmagic.downloader;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.selector.Html;

/**
 * Downloader is the part that downloads web pages and store in Page object. <br>
 * Downloader has {@link #setThread(int)} method because downloader is always the bottleneck of a crawler,
 * there are always some mechanisms such as pooling in downloader, and pool size is related to thread numbers.
 * Base class of downloader with some common methods.
 *
 * @author code4crafter@gmail.com
 * @since 0.5.0
 */
public abstract class Downloader {

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
    
    /**
     * Downloads web pages and store in Page object.
     *
     * @param request request
     * @param task task
     * @return page
     */
    public abstract Page download(Request request, Task task);

    /**
     * Tell the downloader how many threads the spider used.
     * @param threadNum number of threads
     */
    public abstract void setThread(int threadNum);

}
