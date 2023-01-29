package com.example.networktest

import android.util.Log
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler

class ContentHandler : DefaultHandler() {

    private var nodeName = ""

    private lateinit var id: StringBuilder

    private lateinit var name: StringBuilder

    private lateinit var version: StringBuilder

    override fun startDocument() {
        id = StringBuilder()
        name = StringBuilder()
        version = StringBuilder()
    }

    override fun startElement(
        uri: String?,
        localName: String?,
        qName: String?,
        attributes: Attributes?
    ) {
        // 记录当前节点名
        nodeName = localName!!
        Log.d("ContentHandler", "The uri is $uri, localName is $localName, qName is $qName, attributes is $attributes")
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {
        // 根据当前节点名判断将内容添加到哪一个StringBuilder对象中
        when (nodeName) {
            "id" -> id.append(ch, start, length)
            "name" -> name.append(ch, start, length)
            "version" -> version.append(ch, start, length)
        }
    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        if ("app" == localName) {
            Log.d("ContentHandler", "The id is ${id.toString().trim()}, name is ${name.toString().trim()}, version is ${version.toString().trim()}")
            // 最后清空StringBuilder
            id.setLength(0)
            name.setLength(0)
            version.setLength(0)
        }
    }

    override fun endDocument() {
    }
}