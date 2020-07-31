package com.page.mynewapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.aspose.words.Document;
import com.aspose.words.PdfImageCompression;
import com.aspose.words.PdfSaveOptions;
import com.aspose.words.PdfTextCompression;
import com.aspose.words.SaveFormat;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.widget.Toast.LENGTH_SHORT;

public class Firebase_textActivity extends AppCompatActivity {
    static final int CAPTURE_IMAGE_ACTIVITY = 1;
    private static final int FILE_SELECT_CODE = 0;
    final Context CONTEXT = this;
   // private String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/myCamera/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_text);

//        ActivityCompat.requestPermissions(Firebase_textActivity.this,new String[]
//                {Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                PackageManager.PERMISSION_GRANTED);

        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE},
                PackageManager.PERMISSION_GRANTED);

        ImageView camera_imageView = findViewById(R.id.imageView);
        Button textButton = findViewById(R.id.textButtons);
        camera_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);

               // Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                // intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
                //startActivityForResult(intent,  CAPTURE_IMAGE_ACTIVITY);

                startActivityForResult(Intent.createChooser(intent,"select file uplode"),FILE_SELECT_CODE);
                setResult(Activity.RESULT_OK);
//                try {
//                    startActivityForResult(
//                            Intent.createChooser(intent, "Select a File to Upload"),
//                            FILE_SELECT_CODE);
//                } catch (android.content.ActivityNotFoundException ex) {
//                    // Potentially direct the user to the Market with a Dialog
//                    Toast.makeText(this,
//                            "Please install a File Manager.",
//                            LENGTH_SHORT).show();
//                }
            }
        });
       // FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(mselectedimage);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_SELECT_CODE && resultCode == Activity.RESULT_OK) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null && data.getExtras() != null) {

                    //File file = new File(files);
                    //Firebase_textActivity cwoWord = new Firebase_textActivity();
                    String files = data.getDataString();
                    File file = new File(files);
                    //cwoWord.CONTEXT
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Document doc = null;
                            try {
                                doc = new Document(files);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            // PdfSaveOptions options = new PdfSaveOptions();
                            String outputPath = files.substring(0, files.lastIndexOf('.')) + ".pdf";
                            try {
                                doc.save(outputPath, SaveFormat.PDF);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    },200);

//                    try {
//                        Document doc = new Document(files);
//                        PdfSaveOptions options = new PdfSaveOptions();
//                       // options.setTextCompression(PdfTextCompression.FLATE);
//                        //options.setImageCompression(PdfImageCompression.AUTO);
//                       // options.setPageIndex(1);
//                       // options.setPageCount(3);
//                        // Convert Word to PDF
//                        String outputPath = files.substring(0, files.lastIndexOf('.')) + ".pdf";
//                        doc.save(outputPath, SaveFormat.PDF);
//
//                        OutputStream os = new BufferedOutputStream(new FileOutputStream(file));
//                        Bitmap bitmap = BitmapFactory.decodeFile(files); //bitmap is always null
//                        Log.d("showmethebitmap", bitmap.toString()); //Error: bitmap is null !
//                        bitmap.compress(Bitmap.CompressFormat.valueOf(file.getAbsolutePath()),100,os);
////                        InputStream doc = new FileInputStream(new File(files));
////                        XWPFDocument document = new XWPFDocument(doc);
////                        PdfOptions options = PdfOptions.create();
////
////                        OutputStream out = new FileOutputStream(new File(outputPath));
////                        PdfConverter.getInstance().convert(document, out, options);
////                        BitmapFactory.Options options = new BitmapFactory.Options();
////                        options.inSampleSize = 2;
////                        Bitmap bitmap =BitmapFactory.decodeFile(file, options);
//
//                        PdfDocument pdfDocument  = new PdfDocument();
//                        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(960,1280,1).create();
//                        PdfDocument.Page page = pdfDocument.startPage(myPageInfo);
//
//                        page.getCanvas().drawBitmap(bitmap,0,0, null);
//                        pdfDocument.finishPage(page);
////
////                       // String pdfFile = file + "/myPDFFile_3.pdf";
////
//                        String outputPaths = files.substring(0, files.lastIndexOf('.')) + ".pdf";
//                        File myPDFFile = new File(outputPaths);
//                        pdfDocument.writeTo(new FileOutputStream(myPDFFile));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }

                }
            }
        }
    }
    private void onCaptureImageResult(Intent data){
       // Bitmap myBitmap = (Bitmap) data.getExtras().get("data");
        String file = data.getDataString();
        //String file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+ data.getExtras().get();
       // String file = filePath + "data";
        Bitmap bitmap = BitmapFactory.decodeFile(file);
        PdfDocument pdfDocument  = new PdfDocument();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(960,1280,1).create();
        PdfDocument.Page page = pdfDocument.startPage(myPageInfo);
        page.getCanvas().drawBitmap(bitmap,0,0, null);
        pdfDocument.finishPage(page);

       // String pdfFile = file + "/myPDFFile_3.pdf";
        String outputPath = file.substring(0, file.lastIndexOf('.')) + ".pdf";
        File myPDFFile = new File(outputPath);
        try {
            pdfDocument.writeTo(new FileOutputStream(myPDFFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Button textButton = findViewById(R.id.textButtons);
//        textButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + bitmap.toString();
//                String outputPath = filePath.substring(0, filePath.lastIndexOf('.')) + ".pdf";
//                convertText(filePath, outputPath);
//            }
//        });

    }
//    private void convertText(String textFilePath, String outputPath) {
//        FileInputStream fis = null;
//        DataInputStream in = null;
//        InputStreamReader isr = null;
//        BufferedReader br = null;
//        try {
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
//            document.open();
//            File file = new File(textFilePath);
//            if (file.exists()) {
//                fis = new FileInputStream(file);
//                in = new DataInputStream(fis);
//                isr = new InputStreamReader(in);
//                br = new BufferedReader(isr);
//                String strLine;
//                while ((strLine = br.readLine()) != null) {
//                    Paragraph para = new Paragraph(strLine + "\n");
//                    para.setAlignment(Element.ALIGN_JUSTIFIED);
//                    document.add(para);
//                }
//                showAlertDialog("Converting text...", "Converting text to PDF finished... Generated PDF saved in " + outputPath);
//            } else {
//                showAlertDialog("Converting text...", "File " + textFilePath + " does not exist!");
//            }
//            document.close();
//        } catch (Exception e) {
//            showAlertDialog("Converting text...", "An error has occurred: " + e.getMessage());
//        }
//    }
//    private void showAlertDialog(String title, String message) {
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CONTEXT);
//        alertDialogBuilder.setTitle(title);
//        alertDialogBuilder
//                .setMessage(message)
//                .setCancelable(false)
//                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//        // create alert dialog
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        // show it
//        alertDialog.show();
//    }

}