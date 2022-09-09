package com.s3873827.rest.dao;

import com.s3873827.rest.model.Item;
import org.springframework.stereotype.Repository;
import com.s3873827.rest.model.Items;

import java.util.Objects;


@Repository
public class ItemDAO
{
    private static Items list = new Items();

    static
    {
        list.getItemList().add(
                new Item(
                        "0",
                        "M&M's Milk Chocolate Party Size Bucket (640g)",
                        "About this item:\n" +
                                "Package includes 1 x 640g party size bucket of M and M's milk chocolate\n" +
                                "Made with real milk chocolate and surrounded by a colorful thin crisp shell\n" +
                                "It's not a party without these bad boys, M and M's milk chocolate buckets are perfect for any party or celebration\n" +
                                "M and M'S Milk Buckets have a resealable lid so they're easy to share with friends and family\n" +
                                "Add delicious fun and color to your day with M and M'S Milk Chocolate",
                        10.80)
        );
        list.getItemList().add(
                new Item(
                        "1",
                        "Wicked Energy Drink, 24 x 250 ml",
                                "About this item:\n" +
                                "The energy drink that unleashes your wicked side\n" +
                                "Wicked combines attitude with caffeine and taurine\n" +
                                "Energising and refreshing drink\n" +
                                "Perfect pick me up for any time of the day",
                        28.79)
        );
        list.getItemList().add(
                new Item(
                        "2",
                        "T Tersely USB 3.0 to SATA External Hard Drive Enclosure Adapter Case, Transparent LED Indicator 7mm/9.5mm 2.5-Inch SATA I/II/III/SSD/HDD Hard Disk Data Transfer PC/Laptop [Support UASP][Auto Sleep]",
                        "About this item:\n" +
                                "USB 3.0（5Gbps) external enclosure with USB 3.0 connector providing ultra fast read and write speed for external 2.5-inch SATA hard drive, HDD and SSD connecting to desktop and laptop.\n" +
                                "Supports Most 7mm/9.5mm 2.5 inch SATA I/II/III HDD and SSD up to 2TB (Max). Seagate/WD/HGST/etc. and SSD - Intel, Samsung, SanDisk, Micron/Plextor etc.\n" +
                                "Elegant Transparent design, Hot-swappable, Plug & Play, UASP supported; Compatible with Windows 7, 8, 8.1, 10 and MAC OS X 10.6 or above; Supports Apple MacBook Pro 2016, desktop PC or newest motherboard by ASUS, MSI, Gigabyte. Downwards compatible with USB2.0 and USB1.1\n" +
                                "Easy installation, No tools required. LED Indicators. Auto Sleep if No data transfer in 3 minutes.\n" +
                                "Packing includes: 1 x 2.5\" Hard Drive Enclosure, 1 x 50cm USB 3.0 Cable.",
                        12.95)
        );
        list.getItemList().add(
                new Item(
                        "3",
                        "Optimum Nutrition Gold Standard 100% Whey Protein Powder, Double Rich Chocolate, 907 Grams",
                        "About this item:\n" +
                                "Product Type: Health Personal Care\n" +
                                "Package Quantity: 1\n" +
                                "Model Number: 652493\n" +
                                "Country Of Origin: United States",
                        69.99)
        );
        list.getItemList().add(
                new Item(
                        "4",
                        "Ethernet Cable Cat 7 DanYee Flat High Speed Nylon LAN Network Patch Cable Gold Plated Plug STP Wires CAT 7 RJ45 Ethernet Cable 0.5M 1M 2M 3M 5M 8M 10M 15M 20M",
                        "About this item:\n" +
                                "HIGHER SPEED：Compared with existing cat5/cat6 lan calbe,Cat7 ethernet cable support bandwidth up to 600MHz & transmitting data at speeds of up to 10Gbps ,connect to LAN/WAN segments and networking gear at maximum speeds.\n" +
                                "COMPATIBILITY: Cat7 ethernet cable Supports all devices with RJ45 conectors,offer universal connectivity to computers and network components, such as Wi-Fi router, modem, printer, XBox, PS2, PS3, PS4 and switch box and other networking equipment.\n" +
                                "NO INTERFERENCE:Made by 4 shielded twisted pairs (STP) of copper wire with gold plated, Compared with other network Ethernet cable, the additional shielding and improved quality in twisting of the wires provides better protection from crosstalk, noise, and interference that can degrade the signal quality.\n" +
                                "ATTRACTIVE APPEARANCE&DIRTY PROOF:Braided nylon made the cat7 lan cable more elegant and stronger than others,at the same time,because of the special surface the cable is dirty proof!\n" +
                                "ONE YEAR FREE WARRANTY:At our shop,We offer 1 year Hassle-free warranty and lifetime customer service.* NOTE: We do not provide one-year quality guarantee for items of OTHER BRANDS.Please be careful to purchase.",
                        24.99)
        );
    }

    public static Items getItemsList()
    {
        return list;
    }


    public static void addItem(Item item)
    {
        list.getItemList().add(item);
    }

    public Item updateItem(String id, Item data)
    {
        Item item = null;
        boolean found = false;

        for (int i=0; i<list.getItemList().size() && !found; ++i)
            if (Objects.equals(list.getItemList().get(i).getId(), id))
            {
                item = list.getItemList().get(i);
                found = true;
            }

        if (found) {
            if (data.getId() != null)
                item.setId(data.getId());

            if (data.getName() != null)
                item.setName(data.getName());

            if (data.getDesc() != null)
                item.setDesc(data.getDesc());

            if (data.getPrice() != 0.0)
                item.setPrice(data.getPrice());
        }

        return item;
    }

    public Item deleteItem(String id)
    {
        Item item = null;
        boolean found = false;

        for (int i=0; i<list.getItemList().size() && !found; ++i)
            if (Objects.equals(list.getItemList().get(i).getId(), id))
            {
                item = new Item(list.getItemList().get(i));
                found = true;
                list.getItemList().remove(i);
            }

        return item;
    }
}
