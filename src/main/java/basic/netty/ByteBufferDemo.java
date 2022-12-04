package basic.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import java.nio.ByteBuffer;

/**
 * Created by zjw Description: Date: 2021/10/27 18:20
 */
public class ByteBufferDemo {

    private static void test() {

        UnpooledByteBufAllocator allocator = new UnpooledByteBufAllocator(true);
        ByteBuf byteBuf = allocator.directBuffer(16);

        // write
        byteBuf.writeInt(16);
        System.out.printf("capacity:%s, writerIdx:%s, readIdx:%d \n", byteBuf.capacity(), byteBuf.writerIndex(),
            byteBuf.readerIndex());
        byteBuf.writeInt(16);
        System.out.printf("capacity:%s, writerIdx:%s, readIdx:%d \n", byteBuf.capacity(), byteBuf.writerIndex(),
            byteBuf.readerIndex());
        for (int i = 0; i < 16; i++) {
            byteBuf.writeInt(i);
        }
        System.out.printf("capacity:%s, writerIdx:%s, readIdx:%d \n", byteBuf.capacity(), byteBuf.writerIndex(),
            byteBuf.readerIndex());
        // read
        for (int i = 0; i < 5; i++) {
            byteBuf.readInt();
        }
        System.out.printf("capacity:%s, writerIdx:%s, readIdx:%d \n", byteBuf.capacity(), byteBuf.writerIndex(),
            byteBuf.readerIndex());

        // slice
        ByteBuf slice = byteBuf.slice(10, byteBuf.readableBytes());
        System.out.printf("[slice]: capacity:%s, writerIdx:%s, readIdx:%d \n", slice.capacity(), slice.writerIndex(),
            slice.readerIndex());

        // discard
        byteBuf.discardReadBytes();
        System.out.printf("capacity:%s, writerIdx:%s, readIdx:%d \n", byteBuf.capacity(), byteBuf.writerIndex(),
            byteBuf.readerIndex());

        // clear
        byteBuf.clear();
        System.out.printf("capacity:%s, writerIdx:%s, readIdx:%d \n", byteBuf.capacity(), byteBuf.writerIndex(),
            byteBuf.readerIndex());

        byteBuf.release();
    }

    private void testJavaByteBuf() {

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(16);


    }

    public static void main(String[] args) {

        test();
    }

}
