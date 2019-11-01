package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO was introduced in Java 1.4
 * Non blocking I/O
 *
 * - Buffers (abstract class Buffer)
 * - Channels
 * - Charsets
 * - Selectors
 *
 * https://dzone.com/articles/java-io-and-nio
 *
 * NIO.2 was introduced in Java 1.7
 *
 * http://www.concretepage.com/java/jdk7/
 * https://www.developer.com/java/data/exploring-the-new-java-inputoutput-java-nio.2-packages.html
 *
 * - NIO.2 delegates some of the responsibilities of time-consuming activity such as input/output buffering
 *   to the underlying OS. This improves performance.
 * - NIO.2 uses a block-oriented approach of data streaming rather than java.io's sequential streaming.
 * - Sequential streaming is excellent for chained filtering but bad for cached data manipulation.
 * - NIO.2 deals with data in blocks; the blocks are produced and consumed through buffers.
 *   As a result, moving to and fro within the buffered data gives more flexibility during processing.
 * - Because NIO.2 streaming is channel based, a single thread can manage multiple threads.
 * - Blocking a stream of NIO.2 is not good for parsing.
 *   Conventional input/output is comparatively simple and efficient due to its sequential bits transmission.
 *
 */
public class GeneralInfo {
  public static void main(String[] args) throws IOException {

    final File file = new File("1.txt");
    FileChannel channel = new FileInputStream(file).getChannel();

    final ByteBuffer buf = ByteBuffer.allocate(20);
    StringBuilder content = new StringBuilder();

    while (channel.read(buf) != -1) {
      content.append(new String(buf.array()));
      buf.clear();
    }

    System.out.println(content.toString());
  }
}
